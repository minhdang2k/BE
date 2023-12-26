package Lab7.Ex4;

public class Person {
    public String name;
    public int age;
    public String address;

    public Person(String name, int age, String address){
        this.name= name;
        this.age= age;
        this.address= address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }
    void disPlay(){
        System.out.println("Name: "+this.name);
        System.out.println("Age: "+this.age);
        System.out.println("Adress: "+this.address);
    }
}
