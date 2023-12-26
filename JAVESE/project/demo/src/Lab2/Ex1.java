package Lab2;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap phep tinh mong muon: ");
        String pheptinh = scanner.nextLine();
        System.out.println("Nhap a: ");
        float a = scanner.nextFloat();
        System.out.println("Nhap b: ");
        float b = scanner.nextFloat();

        float kq=0;
        boolean valid = true;
        switch (pheptinh) {
            case "+":
                kq = a + b;
                break;
            case "-":
                kq = a - b;
                break;
            case "*":
                kq = a * b;
                break;
            case "/":
                if (b != 0) {
                    kq = a / b;
                } else {
                    System.out.println("Khong the chia cho so 0");
                }
                break;
            default:
                valid = false;
                System.err.println("Phep tinh khong hop le");
        }
        if (valid) {
            System.out.println("Ket qua = " + kq);
        }
        scanner.close();
    }

}

