package DangTieuMinh_JavaSE_Final_Test.Ex1;

import java.util.Scanner;

public class ThiSinh extends Nguoi{
    private String maThiSinh;
    private int toan;
    private int van;
    private int anh;

    public ThiSinh() {
    }

    public ThiSinh(String ten, String ngaySinh, String maThiSinh, int toan, int van, int anh) {
        super(ten, ngaySinh);
        this.maThiSinh = maThiSinh;
        this.toan = toan;
        this.van = van;
        this.anh = anh;
    }
    public void nhapThongtin(Scanner scanner){
        super.nhapThongTin(scanner);
        System.out.println("Nhap ma thi sinh: ");
        this.maThiSinh= scanner.nextLine();
        System.out.println("Nhap diem toan: ");
        this.toan=scanner.nextInt();
        System.out.println("Nhap diem van: ");
        this.van=scanner.nextInt();
        System.out.println("Nhap diem anh: ");
        this.anh=scanner.nextInt();
    }
    public int diemToan(){
        return this.toan;
    }
    public int diemVan(){
        return this.van;
    }
    public int diemAnh(){
        return this.anh;
    }
    public double tinhDiemTB(){
        return (toan+van+anh)/3;
    }
    public void kiemTraSV(){
        if (tinhDiemTB()>=5){
            System.out.println("Sinh vien da trung tuyen");
        }
        else if (tinhDiemTB()>=8.5 && toan>=7 && van>=7 && anh>=7){
            System.out.println("Chuc mung sinh vien dat duoc hoc bong gioi");
        }
        else if (tinhDiemTB()>=0){
            System.out.println("Sinh vien da truot");
        }
    }
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.println("Ma thi sinh: "+this.maThiSinh);
        System.out.println("Diem toan"+this.toan);
        System.out.println("Diem van"+this.van);
        System.out.println("Diem anh"+this.anh);
        kiemTraSV();
    }
}
