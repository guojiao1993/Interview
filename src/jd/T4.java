package jd;

public class T4 {
    private static int x = 10;
    private static Integer y = 10;
    public static void update(int value) {
        value = 3 * value;
    }
    public static void update(Integer value) {
//        value = 3 * value;
    }
    public static void main(String[] args) {
        update(x);
        update(y);
        System.out.println(x);
        System.out.println(y);
    }
}
