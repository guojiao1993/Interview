package pinduoduo.exam722;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意while处理多个case
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            String[] p = new String[m];
            for (int i = 0; i < m; i++) {
                p[i] = in.next();
            }
            // 统计票数情况
            int[][] t = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (p[k].charAt(i) < p[k].charAt(j)) {
                            t[i][j]++;
                        } else if(p[k].charAt(i) > p[k].charAt(j)){
                            t[j][i]++;
                        }
                    }
                }
            }
            // 决出球王
            int[][] r = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if(t[i][j] > t[j][i]) {
                        r[i][j]++;
                        r[j][i]--;
                    } else if(t[i][j] < t[j][i]) {
                        r[i][j]--;
                        r[j][i]++;
                    }
                }
            }
            int[] k = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i != j) {
                        k[i] += r[i][j];
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            int king = -1;
            for (int i = 0; i < n; i++) {
                if(k[i] > max) {
                    max = k[i];
                    king = i;
                } else if(k[i] == max){
                    king = -1;
                }
            }
            System.out.println(king);
        }
    }
}
