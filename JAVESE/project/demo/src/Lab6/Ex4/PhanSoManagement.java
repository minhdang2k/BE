package Lab6.Ex4;

import java.util.Scanner;

public class PhanSoManagement {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Phanso p1=new Phanso();
        Phanso p2=new Phanso();
        System.out.println("Nhap phan so p1: ");
        p1.input(scanner);
        p1.kiemtra();
        System.out.println("Nhap phan so p2: ");
        p2.input(scanner);
        p2.kiemtra();
        Phanso p3=new Phanso();
        p1.congPhanSo(p2);
        p3=p1.congPhanSo(p2);
        p3.rutGonPhanSo();
        p3.hienThiPhanSo();



        scanner.close();
    }
}
