package Lab8;

public class Administration extends Lab8.Staff {
    protected int allowance;
    public Administration(String name, int id, int basicSalary, int seniority, int allowance){
        super(name, id, basicSalary, seniority);
        this.allowance= allowance;
    }

    public void setAllowance(int allowance) {
        if (allowance<0){
            System.out.println("Phụ cấp không hợp lệ");
            this.allowance=0;
        }
        this.allowance = allowance;
    }

    public int getAllowance() {
        return allowance;
    }

    @Override
    public double getSalary() {
        return super.getSalary()+this.allowance;
    }
}
