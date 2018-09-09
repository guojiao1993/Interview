package jd;

public class T3 {
    public static void main(String[] args) {
        System.out.println(B2.c);
    }
}
class A2 {
    public final static String c = "C";
    static {
        System.out.print("A");
    }
}
class B2 extends A2 {
    static {
        System.out.print("B");
    }
}