package Lab6.Ex3;

import java.util.Scanner;

public class PhuongTrinh {
    float a;
    float b;
    float c;
    void input(Scanner scanner){
        System.out.println("Nhap a: ");
        this.a= scanner.nextFloat();
        System.out.println("Nhap b: ");
        this.b= scanner.nextFloat();
        System.out.println("Nhap c: ");
        this.c= scanner.nextFloat();
    }
    float timDelta(){
        return this.b*this.b - 4*this.a*this.c;
    }
    void giaiPhuongtrinh(){
        float x0= -this.b/(2*this.a);
        double x1= (-this.b+Math.sqrt(timDelta()))/(2*this.a);
        double x2= (-this.b-Math.sqrt(timDelta()))/(2*this.a);
        if (timDelta()<0){
            System.out.println("Phuong trinh vo nghiem");
        } else if (timDelta()==0) {
            System.out.println("Phuong trinh co nghiem kep x1=x2= "+x0);
        } else if (timDelta()>0) {
            System.out.println("Phuong trinh co 2 nghiem phan biet: x1= "+x1+" x2= "+x2);
        }
    }
}
