package haoweilai;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[] result = new long[t];
        for (int i = 0; i < t; i++) {
            long x = in.nextLong();
            long k = in.nextLong();
            long y = 0;
            while (k > 0) {
                y++;
                if (x + y == (x | y)) {
                    k--;
                }
            }
            result[i] = k;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}