package tesst;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        // chieu dai chieu rong

        //B1: khoi tao doi tuong Scanner
        Scanner scanner = new Scanner(System.in);

        //B2: Cho ng dung nhap chieu dai & chieu rong
        System.out.println("Nhap chieu dai");
        int chieudai = scanner.nextInt();
        System.out.println("Nhap chieu rong");
        int chieurong = scanner.nextInt();

        //B3: Tinh chuvi & dientich

        int chuvi = (chieudai + chieurong) *2;
        int dientich = chieudai * chieurong;
        System.out.println("Chu vi : "+chuvi);
        System.out.println("Dien tich: "+dientich);

        // Close
        scanner.close();
    }
}
