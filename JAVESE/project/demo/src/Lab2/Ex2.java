package Lab2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhap diem toan: ");
        float toan= scanner.nextFloat();
        System.out.println("Nhap diem ly: ");
        float ly= scanner.nextFloat();
        System.out.println("Nhap diem hoa: ");
        float hoa= scanner.nextFloat();
        if(toan>=0 && ly>=0 && hoa>=0) {
        float dtb= (toan + ly + hoa)/3;
            System.out.println("Diem trung binh: " +dtb);

            if(dtb>=0 && dtb<5) {
                System.out.println("Xep loai yeu");
            } else if (dtb>=5 && dtb<6.5){
                System.out.println("Xep loai trung binh");
            } else if (dtb>=6.5 && dtb<8){
                System.out.println("Xep loai kha");
            } else if (dtb>=8 && dtb<10){
                System.out.println("Xep loai gioi");
            } else if (dtb==10){
                System.out.println("Xep loai xuat xac");
            } else {
                System.out.printf("Diem khong hop le");
            }
        }
        else {
            System.out.println("Diem khong hop le nhap lai: ");
        }



        scanner.close();
    }
}
