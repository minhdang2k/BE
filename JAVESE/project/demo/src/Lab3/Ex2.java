package Lab3;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhap so nguyen n: ");
        int n= scanner.nextInt();
        yc1(n);
        yc2(n);
        yc3(n);
        scanner.close();
    }
    static void yc1(int n){
        int S1=1;
        System.out.println("Yeu cau 1: ");
        for (int i=n; i>=1; i--){
             S1= S1*i;

        }System.out.println("giai thua cua so nguyen n: "+S1);

    }
    static void yc2(int n){
        int S1=1;
        int S2=1;
        System.out.println("Yeu cau 2: ");
        for (int i=n; i>=1; i--){
            S1= S1*i;
            S2 += S1;
        }System.out.println("S2= "+S2);
    }
    static void yc3(int n){
        System.out.println("Yeu cau 3: ");
        int count = 0;
        for (int i=1 ; i<=n ; i++){
            if(i%3==0 && i%7==0){
                System.out.println(i+ " ");
                count++;
            }


        }

        System.out.println("So luong cac so chia het cho 3 va 7: "+count );

    }
}
