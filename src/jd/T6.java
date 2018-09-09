package jd;

public class T6 {
    public static void main(String[] args) {
        System.out.println(Test2.a);
    }
}
class Test2 {
    public static final String a = new String("JD");
    static {
        System.out.print("OK");
    }

//    public static final String a = "JD";
//    static {
//        System.out.print("OK");
//    }

//    public static String a;
//    static {
//        a = "JD";
//        System.out.print("OK");
//    }
}
