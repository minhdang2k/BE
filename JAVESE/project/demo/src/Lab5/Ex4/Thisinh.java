package Lab5.Ex4;

import java.util.Scanner;

public class Thisinh {
        String hoten;
        int sobaodanh;
        float mon1;
        float mon2;
        float mon3;

        String hsgioi;
        String dtut;
        void inputts(Scanner scanner){
            System.out.println("Nhap ho ten: ");
            this.hoten=scanner.nextLine();
            System.out.println("Nhap so bao danh: ");
            this.sobaodanh=scanner.nextInt();
            System.out.println("Nhap diem mon 1: ");
            this.mon1=scanner.nextFloat();
            System.out.println("Nhap diem mon 2: ");
            this.mon2=scanner.nextFloat();
            System.out.println("Nhap diem mon 3: ");
            this.mon3=scanner.nextFloat();
            System.out.println("Co phai la hoc sinh gioi khong");
            this.hsgioi=scanner.nextLine();
            scanner.nextLine();
            System.out.println("Co phai la doi tuong uu tien khong");
            this.dtut=scanner.nextLine();

        }
        float tinhDiemXetTuyen(){
            float diemhsg= 0;
            float diemdtut= 0;
            if("co".equals(this.hsgioi)){
                diemhsg= 1;
            }
            if ("co".equals(this.dtut)){
                diemdtut= 0.5f;
            }
            return this.mon1 + this.mon2 + this.mon3 + diemhsg + diemdtut;
        }
        boolean kiemTraDiemLiet(){
            if (this.mon1==0 || this.mon2==0 || this.mon3==0){
                return true;
            } return false;
        }
}
