/*package Lab2;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap giay: ");
        int giay = scanner.nextInt();
        System.out.println("Nhap phut: ");
        int phut = scanner.nextInt();
        System.out.println("Nhap gio: ");
        int gio = scanner.nextInt();
        if (gio < 0 || gio > 23 || phut < 0 || phut > 59 || giay < 0 || giay > 59) {
            System.out.println("Thoi gian khong hop le moi nhap lai: ");
        } else {
            System.out.println("Valid time: " + displaytime(gio, phut, giay));
            beforeonesecond(gio, phut, giay);
            afteronesecond(gio, phut, giay);
        }
        scanner.close();
    }
    static String displaytime(int h, int p, int g) {
        return h + ":" + p + ":" + g;
    }

    static void beforeonesecond(int h, int p, int g) {
        // 00:00:00 23:59:59
        if (g > 0) {
            g -= 1;
        } else {
            g=59;
            if (p > 0) {
                p -= 1;
            } else {
                p=59;
                if (h > 0) {
                    h -= 1;
                } else {
                    p = 59;
                    g = 59;
                    h = 23;
                }
            }
        }
        System.out.println("Before 1 second: " + displaytime(h, p, g));
    }

}
    static void afteronesecond(int h,int p,int g){
        //  23:59:59 00:00:00
        if(g<59){
            g+= 1;
        }else {
            g=0;
            if(p<59){
                p+=1;

            }else{
                p=0;
                if(h<23) {

                    h += 1;
                }else{

                    h=0;
                }
            }
        }
        System.out.println("After 1 second: "+displaytime(h, p, g));
    }


}*/


