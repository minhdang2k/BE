package Lab3;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhap so luong hang ghe : ");
        int row= scanner.nextInt();
        System.out.println("Nhap so luong ghe trong hang: ");
        int column= scanner.nextInt();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tSƠ ĐỒ CHỖ NGỒI");
        System.out.println("====================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tMÀN HÌNH");
        System.out.println("====================================================================================================");
        for (char c = 'A'; c<'A' + row; c++){
            System.out.print(c + "\t\t");
            for (int i=0; i<column;i++){
                // (i<10) ? ("0"+i):i
                System.out.print(laysoghe(i));
            }
            System.out.println();
        }
        scanner.close();
    }
    static String laysoghe(int i){
        i++;
        return "["+(i<10? "0" + i : i)+"]\t";
    }
}
