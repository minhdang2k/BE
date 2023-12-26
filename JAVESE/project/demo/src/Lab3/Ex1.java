package Lab3;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so nguyen n: ");
        int n = scanner.nextInt();
        yc1(n);
        yc2(n);
        yc3(n);
        yc4(n);
        scanner.close();
    }

    static void yc1(int n) {
        System.out.println("Yeu cau 1 : ");
        for (int i = 1; i <= n; i++) {

            System.out.println(i + " ");
        }
    }

    static void yc2(int n) {
        System.out.println("Yeu cau 2 : ");
        for (int i = n; i >= 1; i--) {
            System.out.println(i + " ");
        }
    }

    static void yc3(int n) {
        System.out.println("Yeu cau 3 : ");
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.println(i + " ");
            }
        }
    }

    static void yc4(int n) {
        System.out.println("Yeu cau 4 : ");
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " ");
            }
        }
    }
}