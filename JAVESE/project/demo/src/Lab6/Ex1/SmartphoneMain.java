package Lab6.Ex1;

import java.util.Scanner;

public class SmartphoneMain {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Smartphone s1= new Smartphone();
        Smartphone s2= new Smartphone();
        s1.inputPhone(scanner);
        s1.showInfo();
        s2.inputPhone(scanner);
        s2.showInfo();
        System.out.println(s1.comparePhone(s2));
        scanner.close();
    }
}
