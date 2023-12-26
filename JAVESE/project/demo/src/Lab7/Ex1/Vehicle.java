package Lab7.Ex1;

import java.util.Objects;

public class Vehicle {
    private String tenChuxe;
    private String tenLoaixe;
    private int dungTichxe;
    private int triGiaxe;
    public Vehicle(){
        this.tenChuxe= "";
        this.tenLoaixe= "";
        this.dungTichxe= 0;
        this.triGiaxe= 0;
    }

    public Vehicle(String tenChuxe, String tenLoaixe, int dungTichxe, int triGiaxe){
        this.tenChuxe=tenChuxe;
        this.tenLoaixe=tenLoaixe;
        this.dungTichxe=dungTichxe;
        this.triGiaxe=triGiaxe;
    }


    public int thueTruocba(){
        if (this.dungTichxe<100){
            return  this.triGiaxe/100;
        }
        else if (this.dungTichxe>=100 && this.dungTichxe<=200) {
            return  (this.triGiaxe*3)/100;
        }
        return (this.triGiaxe*5)/100;
    }

    public void setTenChuxe(String tenChuxe) {
        if (Objects.equals(tenChuxe, "")){
            tenChuxe="Khong biet";
        }
        this.tenChuxe = tenChuxe;
    }

    public void setTenLoaixe(String tenLoaixe) {
        if (Objects.equals(tenLoaixe, "")) {
            tenLoaixe = "Khong biet";
        }
        this.tenLoaixe=tenLoaixe;
    }

    public void setDungTichxe(int dungTichxe) {
        if (dungTichxe<0) {
            dungTichxe = 0;
        }this.dungTichxe= dungTichxe;
    }
    public void setTriGiaxe(int triGiaxe) {
        if (triGiaxe<0) {
            triGiaxe = 0;
        } this.triGiaxe= triGiaxe;

    }

    public int getDungTichxe() {
        return dungTichxe;
    }

    public int getTriGiaxe() {
        return triGiaxe;
    }

    public String getTenChuxe() {
        return tenChuxe;
    }

    public String getTenLoaixe() {
        return tenLoaixe;
    }
    public void hienThiThongTin(){
        System.out.println("Ten chu xe: "+this.tenChuxe+"\t Ten loai xe: "+this.tenLoaixe+
                "\t co dung tich: "+this.dungTichxe+"\t co gia: "+this.triGiaxe);
    }
}
