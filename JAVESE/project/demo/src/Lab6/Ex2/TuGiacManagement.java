package Lab6.Ex2;

import java.util.Scanner;

public class TuGiacManagement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Tugiac t1=new Tugiac();
        Tugiac t2=new Tugiac();
        Tugiac t3=new Tugiac();
        System.out.println("Nhap doi tuong 1");
        t1.input(scanner);
        t1.veTuGiac();
        t1.ketluan();
        System.out.println("Nhap doi tuong 2");
        t2.input(scanner);
        t2.veTuGiac();
        t2.ketluan();
        System.out.println("Nhap doi tuong 3");
        t3.input(scanner);
        t3.veTuGiac();
        t3.ketluan();
        scanner.close();
    }
}
