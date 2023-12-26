package tesst;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so goi hang duoc gui package: ");
        int pack= scanner.nextInt();
        System.out.println("Nhap khoang cach gui distance: ");
        float distance= scanner.nextFloat();
        System.out.println("Nhap so ngay lam viec shift: ");
        int shift= scanner.nextInt();
        System.out.println("Nhap so luong phan hoi feedback: ");
        int feedback= scanner.nextInt();
        System.out.println("Nhap so luong cuoc goi call: ");
        int call= scanner.nextInt();
        System.out.println("Nhap so tien thanh toan electric: ");
        float electric= scanner.nextFloat();
        System.out.println("Nhap so tien thanh toan them other: ");
        float other= scanner.nextFloat();

        double salary= (pack * 50) + (distance *75) + (shift * 50 * 0.1) + feedback + call + electric + other;
        System.out.println("Tong luong: "+salary);
        scanner.close();
    }
}
