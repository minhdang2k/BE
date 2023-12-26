package ls10.lab.model;

public class Order {
    private String number;
    private String date;
    private int quantity;
    private double price;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number='" + number + '\'' +
                ", date='" + date + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
