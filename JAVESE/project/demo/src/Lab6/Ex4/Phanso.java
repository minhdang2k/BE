package Lab6.Ex4;

import java.util.Scanner;

public class Phanso {
    float tuso;
    float mauso;

    public Phanso(float tuso, float mauso) {
        this.tuso = tuso;
        this.mauso = mauso;
    }

    public Phanso() {
        this.tuso = 1;
        this.mauso = 1;
    }

    void input(Scanner scanner) {
        System.out.println("Nhap tu so: ");
        this.tuso = scanner.nextFloat();
        System.out.println("Nhap mau so: ");
        this.mauso = scanner.nextFloat();
    }

    void kiemtra() {
        if (this.mauso == 0) {
            System.out.println("phan so khong hop le");
        }
    }

    Phanso congPhanSo(Phanso phanso) {
        // B1 tinh mau chung
        // B2 tinh tu so
        // B3 tinh mau so
        // B4 Khởi tạo 1 phân số có tử số và mẫu số => trả về đối tượng phân số

        float tuSo = this.tuso * phanso.mauso + phanso.tuso * this.mauso;
        float mauSo = this.mauso * phanso.mauso;

        Phanso ps = new Phanso(tuSo, mauSo);

        return ps;
    }

    private float timUSCLN(float a, float b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    void rutGonPhanSo() {
        float i = timUSCLN(this.tuso, this.mauso);
        float tuso1 = this.tuso / i;
        float mauso1 = this.mauso / i;
        System.out.println("Phan so duoc rut gon: " + tuso1 + "/" + mauso1);
    }

    void hienThiPhanSo() {
        System.out.println("Phan so da nhap la: " + this.tuso + "/" + this.mauso);
    }
}
