package Lab7.Ex1;

public class VehicleManagement {
    public static void main(String[] args) {
        Vehicle v1= new Vehicle("Minh","SH",300,250);
        Vehicle v2= new Vehicle();
        v2.setTenChuxe("");
        v2.setTenLoaixe("");
        Vehicle v3= new Vehicle();
        v3.setTenChuxe("Hieu");
        v3.setTenLoaixe("AB");
        v3.setDungTichxe(-50);
        v3.setTriGiaxe(150);
        v1.hienThiThongTin();
        v2.hienThiThongTin();
        v3.hienThiThongTin();
        System.out.println("Thue xe v1: "+v1.thueTruocba());
        System.out.println("Thue xe v2: "+v2.thueTruocba());
        System.out.println("Thue xe v3: "+v3.thueTruocba());
        int sum= v1.thueTruocba() + v2.thueTruocba() + v3.thueTruocba();
        System.out.println("Tong thue truoc ba thu duoc tu 3 xe = "+sum);



    }
}
