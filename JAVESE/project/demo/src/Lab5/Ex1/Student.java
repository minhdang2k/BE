package Lab5.Ex1;

import java.util.Scanner;

public class Student {
    String studentID;
    String firstname;
    String lastname;

    public Student(){
        this.studentID= studentID;
        this.firstname= firstname;
        this.lastname= lastname;
    }

    public void fillInfo(Scanner scanner){
        System.out.println("Nhap id hoc sinh: ");
        studentID= scanner.nextLine();
        System.out.println("Fist name: ");
        firstname=scanner.nextLine();
        System.out.println("Last name: ");
        lastname=scanner.nextLine();
    }
    public void sayHello(){
        System.out.println("Hello! I am["+firstname+"] ["+lastname+"] "+", ID number: ["+studentID+"] ");
    }
}
