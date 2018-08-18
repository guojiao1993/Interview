package beike;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String data = in.next();
        int[] count = new int[14];
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'A') {
                count[1]++;
                continue;
            }
            if(chars[i] == 'T') {
                count[10]++;
                continue;
            }
            if(chars[i] == 'J') {
                count[11]++;
                continue;
            }
            if(chars[i] == 'Q') {
                count[12]++;
                continue;
            }
            if(chars[i] == 'K') {
                count[13]++;
                continue;
            }
            count[Integer.parseInt(String.valueOf(chars[i]))]++;
        }
        // 0：单张轮数；1：剩余牌数；2：最小轮数
        int[] record = new int[10];

    }
}
