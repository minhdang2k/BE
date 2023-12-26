package DangTieuMinh_JavaSE_Final_Test.Ex2.model;

public class Employee {
    private String maNV;
    private String ho_tenLot;
    private String ten;
    private String ngaySinh;
    private String email;
    private String phone;
    private int luong;

    public Employee() {
    }

    public Employee(String maNV, String ho_tenLot, String ten, String ngaySinh
            , String email, String phone, int luong) {
        this.maNV = maNV;
        this.ho_tenLot = ho_tenLot;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.phone = phone;
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHo_tenLot() {
        return ho_tenLot;
    }

    public void setHo_tenLot(String ho_tenLot) {
        this.ho_tenLot = ho_tenLot;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }
}
