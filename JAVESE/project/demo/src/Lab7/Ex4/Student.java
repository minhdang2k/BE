package Lab7.Ex4;

public class Student extends Person {
    double gpa;
    public Student(String name, int age, String address, double gpa ){
        super(name, age, address);
        this.gpa=gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    void disPlay() {
        super.disPlay();
        System.out.println("GPA: "+this.gpa);
    }
}
