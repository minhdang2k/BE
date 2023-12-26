package Lab11;

import Lab11.connect.ConnectMysqlHangKhong;
import Lab11.model.ChungNhan;
import Lab11.model.ChuyenBay;
import Lab11.model.MayBay;
import Lab11.model.NhanVien;
import com.sun.jdi.connect.spi.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLCBmain {
    private static List<NhanVien> dsNhanVien= new ArrayList<>();
    private static List<ChuyenBay> dsChuyenBay= new ArrayList<>();
    private static List<MayBay> dsMaybay= new ArrayList<>();
    private static List<ChungNhan> dsChungNhan= new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean isRunning= false;
        do {
            System.out.println("Menu Mô tả");
            System.out.println("1. Xem danh sách nhân viên");
            System.out.println("2. Xem danh sách chuyến bay");
            System.out.println("3. Xem danh sách chứng nhận");
            System.out.println("4. Xem danh sách máy bay");
            System.out.println("5. Thêm mới nhân viên");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case 1:
                    xemDanhSachNhanVien();
                    break;
                case 2:
                    xemDanhSachChuyenBay();
                    break;
                case 3:
                    xemDanhSachChungNhan();
                    break;
                case 4:
                    xemDanhSachMayBay();
                    break;
                case 5:
                    themMoiNhanVien(scanner);
                    break;
                case 6:
                    isRunning=false;
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }while(isRunning);
        ConnectMysqlHangKhong connectMysqlHangKhong= new ConnectMysqlHangKhong();
        Connection connection= new Connection();
        Connection conn= ConnectMysqlHangKhong.
    }
    public void xemDanhSachNhanVien(){
        for (NhanVien nhanVien : dsNhanVien) {
            System.out.println(nhanVien.toString());
        }
        String query = "SELECT * FROM NhanVien";
    }
    public void xemDanhSachMayBay(){
        for (MayBay mayBay : dsMaybay) {
            System.out.println(mayBay.toString());
        }
        String query = "SELECT * FROM MayBay";
    }
    public void xemDanhSachChuyenBay(){
        for (ChuyenBay chuyenBay : dsChuyenBay) {
            System.out.println(chuyenBay.toString());
        }
        String query = "SELECT * FROM ChuyenBay";
    }
    public void xemDanhSachChungNhan(){
        for (ChungNhan chungNhan : dsChungNhan) {
            System.out.println(chungNhan.toString());
        }
        String query = "SELECT * FROM ChungNhan";
    }
    public void themMoiNhanVien(Scanner scanner, NhanVien nhanVien){
        NhanVien addnhanVien= new NhanVien();
        System.out.println("Nhap MaNV: ");
        addnhanVien.setMaNv(scanner.nextLine());
        System.out.println("Nhap TenNV: ");
        addnhanVien.setTen(scanner.nextLine());
        System.out.println("Nhap LuongNv: ");
        addnhanVien.setLuong(scanner.nextLine());
        dsNhanVien.add(nhanVien);
        System.out.println("Thêm mới nhân viên thành công");
    }
}
