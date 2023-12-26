package Lab5.Ex3;

import java.util.Date;
import java.util.Scanner;

public class Worker {
    String ten;
    int namsinh;
    String congviec;
    String noilamviec;
        public Worker(){
        this.ten=ten;
        this.namsinh=namsinh;
        this.congviec=congviec;
        this.noilamviec=noilamviec;
    }



    void input(Scanner scanner){
        System.out.println("Ten : ");
        ten= scanner.nextLine();
        System.out.println("Nam sinh: ");
        namsinh= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Cong viec: ");
        congviec= scanner.nextLine();

    }
        void findWorkplace() {
      switch (congviec){
          case "giao duc":
              this.noilamviec="truong hoc";
              break;
          case "y te":
              this.noilamviec="benh vien";
              break;
          case "luat":
              this.noilamviec="toa an";
              break;
          case "cong so":
              this.noilamviec="van phong";
              break;
          default:
              this.noilamviec="khong biet";
      }
    }
    String studyOrWork(){
        int tuoi= 2023-namsinh;
        return tuoi<20 ? "dang hoc" : "dang lam viec";
    }
         void output(){
        String status=studyOrWork();
        System.out.println("Ban ten la: "+ten+". Ban "+status+" ve "+congviec+" tai "+noilamviec);
    }
    }