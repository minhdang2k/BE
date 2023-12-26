package Lab7.Ex3;

public class Account {
    private int pin;
    private int soDutk;
    private String tenTk;
    public Account(int soDutk, String tenTk){
        this.soDutk= soDutk;
        this.tenTk= tenTk;
    }

    public int getSoDutk() {
        return soDutk;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
    public int rutTien(int soTien){
        if (soTien<=this.soDutk){
            this.soDutk=this.soDutk-soTien;
            return soTien;
        }else{
            return 0;
        }
    }
    public String chuyenKhoan(Account account, int soTien){
        if (rutTien(soTien)==0){
            return "Chuyen tien khong thanh cong";
        }
            this.soDutk=this.soDutk-soTien;
            account.soDutk= account.soDutk + soTien;
            return "Ban da chuyen khoan thanh cong den ABC ngan hang VCB voi so tien "+soTien;
    }
}
