package nowcoder;

import java.util.Scanner;

/**
 * 辗转相除法求最大公约数
 */
public class MaxGYS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int cs = 0;
        int bcs = 0;
        if (num1 > num2) {
            bcs = num1;
            cs = num2;
        } else {
            bcs = num2;
            cs = num1;
        }
        int ys = 0;
        while ((ys = bcs % cs) != 0) {
            bcs = cs;
            cs = ys;
        }
        System.out.println(cs);
    }
}
