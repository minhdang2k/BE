package Lab5.Ex4;

import java.util.Scanner;

public class DaiHoc {
    String tentruong;
    float diemchuan;

    void xetTuyen(Thisinh thisinh){
        if (thisinh.tinhDiemXetTuyen()>=diemchuan && !thisinh.kiemTraDiemLiet()){
            System.out.println("Chuc mung ban "+thisinh.hoten+" so bao danh "+thisinh.sobaodanh
                    +" da trung tuyen vao truong "+this.tentruong);
        }else{System.out.println("Rat tiec, ban "+thisinh.hoten+" so bao danh "+thisinh.sobaodanh
                +" chua du dieu kien trung tuyen vao "+this.tentruong);
        }
    }
}
