package Lab7.Ex2;

public class Student {
    private int maSo;
    private String hoTen;
    private float diemToan;
    private float diemVan;
    private float diemAnh;

    public Student(int maSo, String hoTen, float diemToan, float diemVan, float diemAnh){
        this.maSo= maSo;
        this.hoTen= hoTen;
        this.diemToan= diemToan;
        this.diemVan= diemVan;
        this.diemAnh= diemAnh;
    }
    public float diemTb(){
        return (this.diemToan + this.diemAnh + this.diemVan)/3;
    }


    public String xepLoai(){
        if (diemTb()>=8.5 && diemTb()<=10){
            return "Xep loai gioi";
        }else if(diemTb()>=6.5 && diemTb()<8.5){
            return "Xep loai kha";
        } else if (diemTb()>=5 && diemTb()<6.5) {
           return "Xep loai trung binh";
        } else if (diemTb()>=3.5 && diemTb()<5) {
            return "Xep loai yeu";
        }
            return "Xep loai kem";
    }
    public void xemThongtin(){
        System.out.println("Ma so: "+this.maSo+"\t - "+"Ho ten: "+this.hoTen+"\t - "+"diem trung binh: "
                +this.diemTb() +"\t - "+xepLoai());
    }
    public String xetHocbong(){
        if (xepLoai()=="gioi"){
            return "duoc cap hoc bong";
        } return "khong co hoc bong";
    }
    public String xetLenlop(){
        if (diemTb()>=5 && diemTb()<=10){
            return "duoc len lop";
        } else if (diemTb()>=3.5 && diemTb()<5) {
            return "thi lai";
        }
            return "o lai lop";
    }
}
