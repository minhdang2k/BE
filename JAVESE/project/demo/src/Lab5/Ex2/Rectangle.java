package Lab5.Ex2;

import java.util.Scanner;

public class Rectangle {
    float chieudai;
    float chieurong;
    public Rectangle(){
        this.chieudai=chieudai;
        this.chieurong=chieurong;
    }
    public void fillInfo(Scanner scanner){
        System.out.println("Nhap chieu dai: ");
        chieudai= scanner.nextFloat();
        System.out.println("Nhap chieu rong: ");
        chieurong=scanner.nextFloat();
    }
    public void dieukien(){
        this.chieudai=chieudai;
        this.chieurong=chieurong;
        if(chieudai<chieurong) {
            System.out.println("Hinh chu nhat khong hop le!!!");
        }
    }
    public void doPerimeter(){
        this.chieudai=chieudai;
        this.chieurong=chieurong;
        float chuvi= (chieudai+chieurong)*2;
        System.out.println("Chu vi hinh chu nhat: "+chuvi);
    }
    public void doArea(){
        this.chieudai=chieudai;
        this.chieurong=chieurong;
        float dientich= chieudai*chieurong;
        System.out.println("Dien tich hinh chu nhat: "+dientich);
    }
}
