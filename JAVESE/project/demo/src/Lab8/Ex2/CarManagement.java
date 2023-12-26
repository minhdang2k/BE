package Lab8.Ex2;

public class CarManagement {
    public static void main(String[] args) {
        Car car1=new Car("Ford","Ford",1997,4,15000);
        Car car2=new Car("Mercedes","Mercedes",2000,9,20000);
        car1.getInfor();
        car2.getInfor();
        System.out.println("Thue xe thu 1: "+car1.calculateTax());
        System.out.println("Thue xe thu 2: "+car2.calculateTax());
        System.out.println("Gia xe thu 1: "+car1.calculatePrice());
        System.out.println("Gia xe thu 2: "+car2.calculatePrice());
    }
}
