package haoweilai;

import java.util.Scanner;

public class Main2_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long[][] input = new long[t][2];
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            String str = scanner.nextLine();
            String[] split = str.split(" ");
            input[i][0] = Long.valueOf(split[0]);
            input[i][1] = Long.valueOf(split[1]);
        }
        for (int i = 0; i < t; i++) {
            func(input[i]);
        }
    }

    public static void func(long[] input) {
        long i = 0;
        long tempX, tempK;
        long x = input[0], k = input[1];
        long y = 0;
        while (x != 0 || k != 0) {
            tempX = x & 1;
            tempK = k & 1;
            if (tempX == 1) {
                i++;
                x >>= 1;
            } else {
                if (tempK == 1) {
                    y |= (tempK << i);
                }
                x >>= 1;
                k >>= 1;
                i++;
            }
        }
        System.out.println(y);
    }

}