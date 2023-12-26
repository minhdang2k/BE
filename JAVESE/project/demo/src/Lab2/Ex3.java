package Lab2;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("giải phương trình bậc hai (ax2 + bx + c = 0) ");
        System.out.println("Nhap a: ");
        float a= scanner.nextFloat();
        System.out.println("Nhap b: ");
        float b= scanner.nextFloat();
        System.out.println("Nhap c: ");
        float c= scanner.nextFloat();
        if (a==0){
            float x= -c/b;
            System.out.println("Phuong trinh co 1 nghiem x= "+x);
        }else {
            float denta= b*b-4*a*c;
            if (denta==0){
                float x0= -b/(2*a);
                System.out.println("Phuong trinh co nghiem kep x1, x2: "+x0);
            }
            else  if(denta>0){
                double x1= (-b + Math.sqrt(denta))/(2*a);
                double x2= (-b - Math.sqrt(denta))/(2*a);
                System.out.println("Phuong trinh co 2 nghiem");
                System.out.println("x1= " +x1);
                System.out.println("x2= "+x2);
            }
            else  if(denta<0){
                System.out.println("Phuong trinh vo nghiem");
            }
        }





        scanner.close();
    }
}
