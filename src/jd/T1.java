package jd;
public class T1 {
    public static void main(String[] args) {
        System.out.print(fun1());
    }
    private static String fun1() {
        try {
            System.out.print("A");
            fun2();
            return "E";
        } finally {
            System.out.print("B");
            return "F";
        }
    }
    private static String fun2() {
        System.out.print("C");
        return "D";
    }
}