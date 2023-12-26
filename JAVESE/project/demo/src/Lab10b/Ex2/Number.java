package Lab10b.Ex2;

public class Number<N1,N2> {
    private N1 a;
    private N2 b;

    public Number(N1 a, N2 b) {
        this.a = a;
        this.b = b;
    }

    public N1 getA() {
        return a;
    }

    public void setA(N1 a) {
        this.a = a;
    }

    public N2 getB() {
        return b;
    }

    public void setB(N2 b) {
        this.b = b;
    }
}
