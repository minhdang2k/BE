package Lab6.Ex2;

import java.util.Scanner;

public class Tugiac {
    float a;
    float b;
    void input(Scanner scanner){
        System.out.println("Nhap canh a: ");
        this.a= scanner.nextFloat();
        System.out.println("Nhap canh b: ");
        this.b= scanner.nextFloat();
    }
    String veTuGiac(){
        if (a==0 && b==0){
            return "Khong the ve hinh";
        }else{
            for(int i = 0; i < this.a; i++) {
                for(int j = 0; j < this.b; j++) {
                    System.out.print("* ");
                }
                System.out.println("");
            }
            System.out.println("--------------------------------------------------");
        }
            return "hinh se duoc ve la";
    }
    float tinhChuVi(){
        return (this.a+this.b)*2;
    }
    float tinhDienTich(){
        return this.a*this.b;
    }
    String phanLoaiTg(){
        if (this.a!=0 && this.b!=0 && this.a==this.b){
            return  "Day la hinh vuong";
        } else if (this.a!=0 && this.b!=0 && this.a!=this.b) {
            return "Day la hinh chu nhat";
        }
            return "Khong biet";
        }
    void ketluan(){
        System.out.println("Hinh "+phanLoaiTg()+" co chu vi la: "+tinhChuVi()+" dien tinh la: "
                +tinhDienTich()+" "+veTuGiac());
    }
    }



