package netease.P811;

import java.util.Scanner;

public class T3_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int z = in.nextInt();
        int k = in.nextInt();
        ;
        char[] chars = new char[a + z];
        // 0：当前a、
        // 1：当前z、
        // 2：当前count、
        // 3：k、
        // 4：是否找到k、
        // 5：index
        int[] record = new int[10];
        record[0] = a;
        record[1] = z;
        record[3] = k;
        long start = System.currentTimeMillis();
        func(chars, record);
        if (record[4] == 1) {
            System.out.println(chars);
        } else {
            System.out.println(-1);
        }
        long end = System.currentTimeMillis();
        long seconds = (end - start) / 1000;
        System.out.println("耗时：" +  seconds / 60 + " 分 " + seconds % 60 + " 秒");
    }

    public static void func(char[] chars, int[] record) {
        if (record[5] >= chars.length) {
            record[2]++;
            if (record[2] == record[3]) {
                record[4] = 1;
            }
            return;
        }
        if (record[0] > 0) {
            if (record[4] == 1) {
                return;
            }
            chars[record[5]] = 'a';
            record[0]--;
            record[5]++;
            func(chars, record);
            record[5]--;
            record[0]++;
        }
        if (record[1] > 0) {
            if (record[4] == 1) {
                return;
            }
            chars[record[5]] = 'z';
            record[1]--;
            record[5]++;
            func(chars, record);
            record[5]--;
            record[1]++;
        }
    }
}