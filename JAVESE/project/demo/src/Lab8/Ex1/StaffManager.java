//package Lab8;
//
//import Lab8.Staff;
//
//import java.util.Scanner;
//
//public class StaffManager {
//    private Staff[] staff;
//    private int countStaff;
//
//    public StaffManager() {
//        this.staff = new Staff[100];
//        this.countStaff = 0;
//    }
//
//    public void input() {
//        for (int i = 0; i < 100; i++) {
//            staff[i] = new Lab8.Administration("Tien" + (i + 1), 123, 10000, 5, 100);
//        }
//    }
//
//    public void output() {
//        for (Staff staff : staff) {
//            staff.showInfo();
//        }
//    }
//
//    public Staff getStaffMaxsalary() {
//        Staff staffMax = staff[0];
//        for (Staff staff : staff) {
//            if (staff.getSalary() > staff.getSalary()) {
//                staffMax = staff;
//            }
//        }
//    }
//
//}
//
//    public static void main(String[] args) {
//        StaffManager manager= new StaffManager();
//        manager.input();
//        manager.output();
//        System.out.println(manager.getStaffMaxsalary());
//    }
//}
