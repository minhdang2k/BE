package Lab5.Ex3;

import java.util.Scanner;

public class WorkerManagement {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Worker worker1= new Worker();
        Worker worker2= new Worker();
        Worker worker3= new Worker();
        worker1.input(scanner);
        worker1.findWorkplace();
        worker1.output();
        worker2.input(scanner);
        worker2.findWorkplace();
        worker2.output();
        worker3.input(scanner);
        worker3.findWorkplace();
        worker3.output();
        scanner.close();
    }
}
