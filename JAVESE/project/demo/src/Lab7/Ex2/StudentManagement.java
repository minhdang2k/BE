package Lab7.Ex2;

public class StudentManagement {
    public static void main(String[] args) {
        Student student=new Student(123,"MinhDang",7f,8.5f,9f);
        student.xemThongtin();
        System.out.println(student.xetHocbong());
        System.out.println(student.xetLenlop());
    }

}
