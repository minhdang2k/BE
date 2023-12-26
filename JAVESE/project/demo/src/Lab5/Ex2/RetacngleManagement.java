package Lab5.Ex2;

import java.util.Scanner;

public class RetacngleManagement {
    public static void main(String[] args) {
        Rectangle rectangle= new Rectangle();
        Scanner scanner= new Scanner(System.in);

        rectangle.fillInfo(scanner);
        rectangle.dieukien();
        rectangle.doPerimeter();
        rectangle.doArea();
        scanner.close();
    }
}
