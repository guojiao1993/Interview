package diy;

import java.util.Scanner;

/**
 * 大数相乘
 */
public class BigNumMultiply {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        if (s1 == null || s1.length() < 1) {
            System.out.println(0);
        }
        if (s2 == null || s2.length() < 1) {
            System.out.println(0);
        }
        int length1 = s1.length();
        int length2 = s2.length();
        int[] result = new int[length1 + length2];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                // result[]的最后一位空着不可能被占用，而num1的第i位与num2的第j位相乘的结果，
                // 原本应该存放在result[]的第i+j位上，但我们把它往后顺移一位（放到第i+j+1位），
                // 从而从右向左累加时就多了一个空间，可用于存放进位。
                result[i + j + 1] += (s1.charAt(i) - 48) * (s2.charAt(j) - 48);
            }
        }
        int jw = 0;
        int index = length1 + length2 - 1;
        while (index >= 0) {
            int num = result[index] + jw;
            if (num >= 10) {
                result[index] = num % 10;
                jw = num / 10;
            } else {
                result[index] = num;
                jw = 0;
            }
            index--;
        }
        boolean isHead = true;
        for (int i = 0; i < length1 + length2; i++) {
            if (isHead && result[i] == 0) {
                continue;
            } else {
                isHead = false;
                System.out.print(result[i]);
            }
        }
        // 特殊情况：结果全0时输出0
        if (isHead) {
            System.out.println(0);
        }
    }
}
