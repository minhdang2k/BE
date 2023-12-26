package Lab10b.Ex2;

public class NumberMain {
    public static void main(String[] args) {

        Number<Integer,Integer> number= new Number<>(10,15);
        int x= (number.getA()+ number.getB())/2;
        int y= number.getA()-x;
        System.out.println("x= "+x);
        System.out.println("y= "+y);
    }
}
