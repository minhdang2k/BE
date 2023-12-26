package ls10.lab.model;

import java.util.List;

public class Customer {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String address;
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String name, String phoneNumber, String address, List<Order> orders) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orders = orders;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}
