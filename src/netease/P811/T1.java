package netease.P811;

import java.util.Scanner;

public class T1 {
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
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (isWake[i] == 1) {
                    max += minutes[i];
                }
            }
            for (int i = 0; i < n; i++) {
                if(isWake[i] == 1) {
                    continue;
                }
                int add = 0;
                for (int j = 0; j < k && (i + k) < n; j++) {
                    if (isWake[i + j] == 1) {
                        continue;
                    }
                    add += minutes[i + j];
                }
                if(max + add > max) {
                    max += add;
                }
            }
            System.out.println(max);
        }
    }
}
