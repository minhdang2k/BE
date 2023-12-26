package Lab3;

import java.util.Random;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Hãy chọn giá đúng");
        mua();
    scanner.close();
    }
    static void mua(){
        Scanner scanner= new Scanner(System.in);
        Random random = new Random();
        int count=0;
        int n=10;
        int diem=10;
        int price= random.nextInt(100)+1; // 1- 100
        System.out.println("Gia san pham: "+price);
        for (int i=1; i<=n; i++){
            System.out.println("Nhap gia mua : ");
            int giamua=scanner.nextInt();
        if (giamua>price){
            System.out.println("Gia mua cao hon gia ban doan lai: ");
            diem--;
            count++;
        }
        else if (giamua<price){
            System.out.println("Gia mua thap hon gia ban doan lai: ");
            diem--;
            count++;
        }
          else if (giamua==price){
                System.out.println("Chuc mung ban da doan dung ");
                break;
            }
        }
        if (diem==0){
            System.out.println("Ban da thua cuoc");
        }else {
            System.out.println("Tong diem cua ban la : " + diem);
            System.out.println("So lan ban doan sai: " + count);
        }
        scanner.close();
    }
}
