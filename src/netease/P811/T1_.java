package netease.P811;

import java.util.Map;
import java.util.Scanner;

public class T1_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int k = in.nextInt();
            int[] minutes = new int[n];
            for (int i = 0; i < n; i++) {
                minutes[i] = in.nextInt();
            }
            int[] isWake = new int[n];
            for (int i = 0; i < n; i++) {
                isWake[i] = in.nextInt();
            }
            int sumOfWake = 0;
            for (int i = 0; i < n; i++) {
                if (isWake[i] == 1) {
                    sumOfWake += minutes[i];
                }
            }
            int sumOfNoWake = 0;
            for (int i = 0; i < Math.min(n, k); i++) {
                if (isWake[i] == 0) {
                    sumOfNoWake += minutes[i];
                }
            }
            if(k >= n) {
                System.out.println(sumOfWake + sumOfNoWake);
            } else {
                int max = 0;
                for (int i = 0; i < (n - k + 1); i++) {
                    if(i == 0) {
                        max = sumOfWake + sumOfNoWake;
                    } else {
                        if (isWake[i - 1] == 0) {
                            sumOfNoWake -= minutes[i - 1];
                        }
                        if(isWake[i + k - 1] == 0) {
                            sumOfNoWake += minutes[i + k - 1];
                        }
                        if (sumOfWake + sumOfNoWake > max) {
                            max = sumOfWake + sumOfNoWake;
                        }
                    }
                }
                System.out.println(max);
            }
        }
    }
}
