package DangTieuMinh_JavaSE_Final_Test.Ex1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ThiSinhManagement {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhap so luong thi sinh: ");
        int n= scanner.nextInt();
        ArrayList<ThiSinh> danhSachThiSinh= new ArrayList<>();
        for (int i=0; i<n; i++){
            ThiSinh thiSinh= new ThiSinh();
            thiSinh.nhapThongtin(scanner);
            danhSachThiSinh.add(thiSinh);
        }
        Collections.sort(danhSachThiSinh, Comparator.comparingDouble(ThiSinh::tinhDiemTB).reversed());
        System.out.println("Danh sach thi sinh giam dan theo diem trung binh: ");
        for (ThiSinh thiSinh : danhSachThiSinh){
            thiSinh.hienThiThongTin();
            System.out.println();
        }
        System.out.println("Danh sach thi sinh dau: ");
        for (ThiSinh thiSinh : danhSachThiSinh){
            if (thiSinh.tinhDiemTB()>=5 && thiSinh.tinhDiemTB()<8.5){
                thiSinh.hienThiThongTin();
                System.out.println();
            }
        }
        System.out.println("Danh sach thi sinh duoc khen thuong: ");
        for (ThiSinh thiSinh : danhSachThiSinh){
            if ( thiSinh.tinhDiemTB()>=8.5 && thiSinh.diemToan()>=7 && thiSinh.diemAnh()>=7 && thiSinh.diemAnh()>=7){
                thiSinh.hienThiThongTin();
                System.out.println();
            }
        }
        ThiSinh tsDiemCaoNhat = danhSachThiSinh.get(0);
        for (ThiSinh thiSinh : danhSachThiSinh){
            if (thiSinh.tinhDiemTB()>tsDiemCaoNhat.tinhDiemTB()){
                tsDiemCaoNhat= thiSinh;
            }
        }
        System.out.println("Thi sinh co diem trung binh cao nhat: ");
        tsDiemCaoNhat.hienThiThongTin();
    }
}
