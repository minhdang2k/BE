package Lab8;

public class Staff {
    protected String name;
    protected int id;
    protected int basicSalary;
    protected int salaryCoefficient;
    protected int seniority;
    public Staff(String name, int id, int basicSalary, int seniority ){
        this.name= name;
        this.id= id;
        this.basicSalary= basicSalary;
        this.seniority= seniority;
    }


    public int getSalaryCoefficient() {
        this.salaryCoefficient= 1+seniority/5;
        return this.salaryCoefficient;
    }

    public void setSeniority(int seniority) {
        if (seniority<0){
            System.out.println("Thâm niên công tac không hợp lệ");
            this.seniority=0;
        }
        this.seniority = seniority;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }
    public double getSalary(){
        return this.basicSalary * getSalaryCoefficient();
    }
    public void showInfo(){
        System.out.println("Ma so nv: "+this.id+" \n Ten nv: "+this.name+"\n luong can ban: "
                +this.basicSalary+"\n he so luong: "+this.salaryCoefficient+" \n tham nien: "+this.seniority);
    }
}