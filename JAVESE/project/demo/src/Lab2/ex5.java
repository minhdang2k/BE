package lab2;

import java.util.Scanner;

import static javax.print.attribute.standard.MediaSizeName.A;
import static javax.print.attribute.standard.MediaSizeName.B;

public class ex5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Người dùng nhập vào một ký tự và chương trình sẽ hiển thị ngôn ngữ tương ứng. ");
        System.out.println("Nhap ky tu: ");
        String nhap= scanner.nextLine();
        boolean valid= true;
        switch (nhap){

            case "A":
            case "a":
                System.out.println("Ada");
                break;
            case "B":
            case "b":
                System.out.println("Basic");
                break;
            case "C":
            case "c":
                System.out.println("Cobol");
                break;
            case "D":
            case "d":
                System.out.println("Android");
                break;
            case "F":
            case "f":
                System.out.println("Fortran");
                break;
            case "W":
            case "w":
                System.out.println("Windows Phone");
                break;
            default:
                valid = false;
                System.err.println("Ban da nhap sai ");
        }

        scanner.close();
    }
}
