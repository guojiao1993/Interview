package netease.P811;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int[] temp = new int[num + 1];
        temp[0] = 0;

        for (int i = 0; i < num; ++i) {
            temp[i + 1] = temp[i] + in.nextInt();
        }

        int cs = in.nextInt();
        for (int i = 0; i < cs; ++i) {
            int q = in.nextInt();
            int begin = 0;
            int end = num;
            while (begin < end) {
                int mid = (begin + end) / 2;
                if (temp[mid] < q) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }
            System.out.println(begin);
        }
    }
}