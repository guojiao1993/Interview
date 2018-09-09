package jd;
public class T2 {
    public static void main(String[] args) throws ClassNotFoundException {
//        new B();
//        Class.forName("jd.B");
        System.out.print(B.c);
    }
}
class A {
    static {
        System.out.print("A");
    }
}
class B extends A {
    public final static String c = "C";
    static {
        System.out.print("B");
    }
}