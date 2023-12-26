package Lab6.Ex1;

import java.util.Scanner;

public class Smartphone {
    String ten;
    String hang;
    int ram;
    float gia;

    public Smartphone(){
        this.ten= "NULL";
        this.hang= "Unknown";
        this.ram=0;
        this.gia=0;

    }
    void inputPhone(Scanner scanner){
        System.out.println("Ten dien thoai: ");
        this.ten= scanner.nextLine();
        System.out.println("Hang SX: ");
        this.hang=scanner.nextLine();
        System.out.println("Ram: ");
        this.ram=scanner.nextInt();
        System.out.println("Gia tien: ");
        this.gia=scanner.nextFloat();
        scanner.nextLine();
    }

    void showInfo(){
        System.out.println("Ten dien thoai: "+this.ten);
        System.out.println("Hang SX: "+this.hang);
        System.out.println("Ram: "+this.ram);
        System.out.println("Gia tien: "+this.gia);
    }
    String comparePhone(Smartphone smartphone){
        if(this.gia<smartphone.gia){
            return "Dien thoai s1 re hon s2";
        }
        if(this.gia>smartphone.gia){
            return "Dien thoai s1 mac hon s2";
        }
        return "Dien thoai s1 bang gia voi dien thoai s2";
    }
}
