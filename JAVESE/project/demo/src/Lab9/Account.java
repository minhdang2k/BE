package Lab9;

import Lab5.Ex5.Date;

import java.util.Scanner;

public class Account {
    int accNumber;
    String name;
    String gender;
    int birth;
    String birthPlace;
    int phoneNumber;
    String email;

    public Account(int accNumber, String name, String gender, int birth, String birthPlace, int phoneNumber, String email) {
        this.accNumber = accNumber;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.birthPlace = birthPlace;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getBirth() {
        return birth;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void getMenu(Scanner scanner) {
        System.out.println("Open an account (enter: open)");
        System.out.println("Make a deposit (enter: deposit)");
        System.out.println("Make a withdraw (enter: withdraw)");
        System.out.println("Show the number of transactions (enter: show)");
        System.out.println("Exit the ATM (enter: quit)");
        System.out.println("Your choice");
        String choice = scanner.nextLine();
        if (choice.equals("open")) {
            System.out.println("Your choice: open");
            System.out.println("Enter your name: " + this.name);
            System.out.println("Enter your gender (male|female): " + this.gender);
            System.out.println("Enter your birthday (dd/mm/yyy): " + this.birth);
            System.out.println("Enter your address: " + this.birthPlace);
            System.out.println("Enter your phone: " + this.phoneNumber);
            System.out.println("Enter your mail: " + this.email);
            System.out.println("-----Successful operation!-----");
            System.out.println("BankAccount: accNumber= " + this.accNumber
                    + " name=" + this.name + ", gender=" + this.gender
                    + ", birthday=" + this.birth + ", address=" + this.birthPlace);
        } else if (choice.equals("deposit")) {
            getDeposit(10000, 5000);
        } else if (choice.equals("withdraw")) {
            getWithdraw(10000, 4000);
        } else if (choice.equals("show")) {
            System.out.println("Your choice: show");
            System.out.println("Enter your account number: " + this.accNumber);
            System.out.println("The number of transactions are 2");
        } else if (choice.equals("quit")) {
            System.out.println("Thank you");
        }
    }


    public  void getDeposit(int soDu, int tienGui){
        try{
           soDu=soDu + tienGui;
        }
        catch (ArithmeticException ex){

            System.out.println(ex);
        }
        finally {
            System.out.println("Your choice: deposit");
            System.out.println("Enter your account number: "+this.accNumber);
            System.out.println("Enter your amount: "+tienGui);
            System.out.println("Your current balance is "+soDu+"$");
            System.out.println("-----Successful operation!-----");
        }
    }
    public  void getWithdraw(int soDu, int tienRut){
        if (soDu>=tienRut) {
            try {
                soDu = soDu - tienRut;
            } catch (ArithmeticException ex) {
                System.out.println(ex);
            } finally {
                System.out.println("Your choice: withdraw");
                System.out.println("Enter your account number: " + this.accNumber);
                System.out.println("Enter your amount: " + tienRut);
                System.out.println("Your current balance is " + soDu);
            }
        }
            else {
                System.out.println("Your choice: withdraw");
                System.out.println("Enter your account number: "+this.accNumber);
                System.out.println("Enter your amount: "+tienRut);
                System.err.println("Sorry, but you are short " + (tienRut - soDu) + "$");
            }


    }
}
