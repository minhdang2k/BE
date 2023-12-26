package Lab4;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] n = {10, 25, -4, 32, 63, 81, 19, -24, 13, 18, 45, 12, 72, 42, -6};

        yc1(n);
        yc2(n);
        yc3(n);
        yc4(n);
        scanner.close();
    }
    static void yc1(int n[]){
        System.out.println("Yeu cau 1");
            for (int i = 0; i < n.length; i++) {
                if (n[i] % 2 != 0) {

                    System.out.println(n[i] + " ");
                    System.out.println("vi tri: " + i + " ");
                }
            }
        }
        static void yc2(int n[]){
        int count=0;
            System.out.println("Yeu cau 2");
            for (int i = 0; i < n.length; i++) {
                if (n[i]%2==0 && n[i]%6==0){

                    count++;

                }

            }   System.out.println("Tong cac phan tu : "+count) ;
        }
    static void yc3(int n[]){
        int sum=0;
        System.out.println("Yeu cau 3");
        for (int i = 0; i < n.length; i++) {
            if (n[i]%2==0 ){

                sum=sum+n[i];

            }

        }   System.out.println("Tong cac phan tu chia het cho 2 : "+sum) ;
    }
    static void yc4(int n[]){
        System.out.println("Yeu cau 4");
        for (int i = 0; i < n.length; i++){
            if (n[i]<0){
                n[i]=0;
            }
            System.out.println(  n[i]+ " " );
        }
    }
}
