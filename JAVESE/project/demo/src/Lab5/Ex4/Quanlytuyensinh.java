package Lab5.Ex4;

import java.util.Scanner;

public class Quanlytuyensinh {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Thisinh thisinh= new Thisinh();
        DaiHoc daiHoc1= new DaiHoc();
        DaiHoc daiHoc2= new DaiHoc();
        DaiHoc daiHoc3= new DaiHoc();

        thisinh.inputts(scanner);
        daiHoc1.tentruong="Đại học Hoa Sen";
        daiHoc1.diemchuan=15;
        daiHoc2.tentruong="Đại học SPKT TPHCM ";
        daiHoc2.diemchuan=23;
        daiHoc3.tentruong="Đại học Sài Gòn";
        daiHoc3.diemchuan=15.5f;
        daiHoc1.xetTuyen(thisinh);
        daiHoc2.xetTuyen(thisinh);
        daiHoc3.xetTuyen(thisinh);
        scanner.close();
    }
}
