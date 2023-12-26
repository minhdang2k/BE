package Lab5.Ex1;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Student student1= new Student();
        Student student2= new Student();
        Student student3= new Student();
        Scanner scanner= new Scanner(System.in);

        student1.fillInfo(scanner);
        student2.fillInfo(scanner);
        student3.fillInfo(scanner);

        student1.sayHello();
        student2.sayHello();
        student3.sayHello();

    }
}
