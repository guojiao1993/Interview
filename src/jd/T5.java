package jd;

public class T5 {
    public static void main(String[] args) {
        System.out.print("A");
        new T5();
        new T5();
    }
    public T5() {
        System.out.print("B");
    }
    {
        System.out.print("C");
    }
    static {
        System.out.print("D");
    }
}
