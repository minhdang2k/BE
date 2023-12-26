package tesst;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // yeu cau 3.1
        System.out.println("Nhap so nguyen x: ");
        int x= scanner.nextInt();
        System.out.println("Nhap so nguyen y: ");
        int y= scanner.nextInt();
        int tong= x+y;
        System.out.println("tong = "+tong);
        int hieu= x-y;
        System.out.println("hieu = "+hieu);
        long tich=(long) x*y;
        System.out.println("tich = "+tich);
        float thuong=(float) x/y;
        System.out.println("thuong = "+thuong);
        int phannguyen= x/y;
        System.out.println("phan nguyen= "+phannguyen);
        double luythua= Math.pow(x,y);
        System.out.println("luy thua = "+luythua);

        // yeu cau 3.2
        System.out.println("Nhap do C: ");
        float c= scanner.nextFloat();
        float f= ((c*9)/5) + 32;
        System.out.println("Chuyen sang do F: "+f);
        scanner.close();
    }

}
