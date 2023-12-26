package Lab6.Ex3;

import java.util.Scanner;

public class PhuongTrinhManagement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        PhuongTrinh pt1= new PhuongTrinh();
        PhuongTrinh pt2= new PhuongTrinh();
        pt1.input(scanner);
        pt1.timDelta();
        pt1.giaiPhuongtrinh();
        pt2.input(scanner);
        pt2.timDelta();
        pt2.giaiPhuongtrinh();


        scanner.close();
    }
}
