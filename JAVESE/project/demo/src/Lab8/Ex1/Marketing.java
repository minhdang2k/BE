package Lab8;

public class Marketing extends Lab8.Staff {
    protected int sales;
public Marketing(String name, int id, int basicSalary, int seniority, int sales ){
    super(name, id, basicSalary, seniority);
    this.sales= sales;
}
 public double getCommission(){
    if (sales>=5000 && sales<10000){
        return 0.05;
    } else  if(sales>=10000 && sales<20000) {
        return 0.1;
    } else  if(sales>=20000) {
        return 0.2;
    }
    return 0;
 }

    public void setSales(int sales) {
    if (sales<0){
        System.out.println("Doanh so khong hop le");
    }
        this.sales = sales;
    }

    public int getSales() {
        return sales;
    }

    @Override
    public double getSalary() {
        return super.getSalary()+this.sales*getCommission();
    }

    public void showInfo(){
        System.out.println("Ma so nv: "+this.id+" \n Ten nv: "+this.name+"\n luong can ban: "
                +this.basicSalary+"\n he so luong: "+this.salaryCoefficient+" \n tham nien: "
                +this.seniority+"Doanh so: "+this.sales);
    }
}
