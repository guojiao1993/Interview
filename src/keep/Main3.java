package keep;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new Main3().getClass().getResourceAsStream("Main3"));
        while (in.hasNext()) {
            long n = in.nextLong();
            int d = in.nextInt();
            char str[] = String.valueOf(n).toCharArray();
            int dd = String.valueOf(d).length();
            int nCnt = str.length;
            int nBit = 1 << nCnt;
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nBit; i++) {
                // 每个组合都要先清空StringBuilder
                sb.delete(0, sb.length());
                for (int j = 0; j < nCnt; j++) {
                    // -1意为第j位是1，否则是0
                    if ((i << (31 - j)) >> 31 == -1) {
                        sb.append(str[j]);
                    }
                }
                String s = sb.toString();
                if (s.length() >= dd && Integer.valueOf(s) % d == 0) {
                    count++;
                    System.out.print(s + " ");
                }
            }
            System.out.println(count);
        }
    }
}
