package netease;

import java.util.Scanner;
public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double d6 = (80000 - 55000) * 0.35;
        double d5 = (55000 - 35000) * 0.3;
        double d4 = (35000 - 25000) * 0.25;
        double d3 = (25000 - 12000) * 0.2;
        double d2 = (12000 - 3000) * 0.1;
        double d1 = (3000 - 0) * 0.03;
        while (in.hasNextInt()) {//注意while处理多个case
            int num = in.nextInt();
            int[] array = new int[num];
            for (int i = 0; i < num; i++) {
                int n = in.nextInt();
                double result = 0;
                if (n <= 5000) {
                    result = 0;
                } else {
                    n -= 5000;
                    if(n > 80000) {
                        result = (n - 80000) * 0.45 + d6 + d5 + d4 + d3 + d2 + d1;
                    } else if(55000 < n) {
                        result = (n - 55000) * 0.35 + d5 + d4 + d3 + d2 + d1;
                    } else if(35000 < n) {
                        result = (n - 35000) * 0.3 + d4 + d3 + d2 + d1;
                    } else if(25000 < n) {
                        result = (n - 25000) * 0.25 + d3 + d2 + d1;
                    } else if(12000 < n) {
                        result = (n - 12000) * 0.2 + d2 + d1;
                    } else if(3000 < n) {
                        result = (n - 3000) * 0.1 + d1;
                    } else {
                        result = n * 0.03;
                    }
                }
                // 四舍五入
                array[i] = (int) Math.floor(result + 0.5);
            }
            for (int i = 0; i < num; i++) {
                System.out.println(array[i]);
            }
        }
    }
}