package Lab8.Ex2;

public class Car implements Actionable {
    protected String name;
    protected String producer;
    protected int year;
    protected int seat;
    protected int price;
    public Car(String name, String producer, int year, int seat, int price){
        this.name= name;
        this.producer= producer;
        this.year= year;
        this.seat= seat;
        this.price= price;
    }

    @Override
    public double calculateTax() {
        if (seat>0 && seat<7){
            return this.price * 0.6;
        }
        return this.price*0.7;
    }

    @Override
    public double calculatePrice() {
        return price+calculateTax();
    }

    @Override
    public void getInfor() {
        System.out.println(this.name+" car produced by "+this.producer+" in "+this.year+" has "
                +this.seat+" seats with the total price is "+this.price+" $ " );
    }
}
