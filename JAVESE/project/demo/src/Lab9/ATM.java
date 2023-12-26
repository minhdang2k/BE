package Lab9;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Account account1=new Account(0,"","",2000
                ,"",68686868,"");
        account1.setAccNumber(001);
        account1.setName("Minh");
        account1.setGender("Male");
        account1.setBirthPlace("Hue");
        account1.setEmail("minhdang2804@gmail.com");

        account1.getMenu(scanner);


        scanner.close();
    }
}
