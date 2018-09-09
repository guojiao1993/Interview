### 关于static
以下代码输出：C，不会执行static代码块

如果去掉注释，则会输出：ABC
```java
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
```
### 关于finally
应该先执行try中所有的代码，然后执行finally，最后再执行try。

以下代码输出：ACBD
```java
public static void main(String[] args) {
    System.out.print(fun1());
}
private static String fun1() {
    try {
        System.out.print("A");
        return fun2();
    } finally {
        System.out.print("B");
    }
}
private static String fun2() {
    System.out.print("C");
    return "D";
}
```
以下代码输出：ACBE，取消掉注释，则输出：ACBF
```java
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
        // return "F";
    }
}
private static String fun2() {
    System.out.print("C");
    return "D";
}
```