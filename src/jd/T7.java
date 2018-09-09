package jd;

public class T7 {
    public static void main(String[] args) throws ClassNotFoundException {
//        ClassLoader.getSystemClassLoader().loadClass("jd.TA");
        Class<TA> c = TA.class;
        System.out.print("Test");
        Class.forName("jd.TA");
    }
}
class TA {
    static {
        System.out.print("A");
    }
}