package DangTieuMinh_JavaSE_Final_Test.Ex1;

import java.util.Scanner;

public class Nguoi {
    private String ten;
    private String ngaySinh;

    public Nguoi() {
    }

    public Nguoi(String ten, String ngaySinh) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public void nhapThongTin(Scanner scanner){
        System.out.println("Nhap ten: ");
        this.ten= scanner.nextLine();
        scanner.nextLine();
        System.out.println("Nhap ngay sinh: ");
        this.ngaySinh= scanner.nextLine();
    }
    public void hienThiThongTin(){
        System.out.println("Ten: "+this.ten);
        System.out.println("Ngay sinh: "+this.ngaySinh);
    }
}
