package Lab7.Ex4;

public class Teacher extends Person {
    int salary;
    public Teacher(String name, int age, String address, int salary){
        super(name, age, address);
        this.salary=salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    void disPlay() {
        super.disPlay();
        System.out.println("Salary: "+this.salary);
    }
}
