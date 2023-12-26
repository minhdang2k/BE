package Lab8;

public class STAXX {
    public static void main(String[] args) {
        Staff staff= new Staff("Minh",0777,15000,50);
        System.out.println(staff.getSalary());
        staff.showInfo();
    }
}
