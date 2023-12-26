package Lab2;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("nhap a: ");
        float a= scanner.nextFloat();
        System.out.println("nhap b: ");
        float b= scanner.nextFloat();
        System.out.println("nhap c: ");
        float c= scanner.nextFloat();
        if(a<=0 || b<=0 || c<=0){
            System.out.println("a b c khong phai la 3 canh cua tam giac");
        } else if (a*a== b*b + c*c ||b*b== a*a + c*c || c*c== b*b + a*a ) {
            System.out.println("a b c la 3 canh cua tam giac can");
        } else if (a==b && a==c ) {
            System.out.println("a b c la 3 canh cua tam giac deu");
        }else if (a==b || a==c || b==c) {
            System.out.println("a b c la 3 canh cua tam giac can");
        }else {
            System.out.println("a b c la 3 canh cua tam giac thuong");
        }


        scanner.close();
    }
}
