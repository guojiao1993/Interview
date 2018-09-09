package jd;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        int m = Integer.valueOf(n);
        long[][] d = new long[m][3];
        for (int i = 0; i < m; i++) {
            String str = in.nextLine();
            String[] split = str.split(" ");
            d[i][0] = Long.valueOf(split[0]);
            d[i][1] = Long.valueOf(split[1]);
            d[i][2] = Long.valueOf(split[2]);
        }
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                if (d[i][0] < d[j][0] && d[i][1] < d[j][1] && d[i][2] < d[j][2]) {
                    System.out.println(i + 1);
                }
            }
        }
    }
}