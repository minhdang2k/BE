package Lab7.Ex3;

public class AccountManagement {
    public static void main(String[] args) {
        Account firstAccount= new Account(1000, "Minh");
        Account secondAccount= new Account(2500, "ABC");
        firstAccount.setPin(6868);
        System.out.println("So du firstAccount: "+firstAccount.getSoDutk());
        System.out.println("firstAccount da rut so tien: "+firstAccount.rutTien(350));
        System.out.println(firstAccount.chuyenKhoan(secondAccount,200));
        System.out.println("So du secondAccount: "+secondAccount.getSoDutk());
    }
}
