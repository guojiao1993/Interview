package bytedance;

import java.util.Scanner;

public class T1 {
    public static void func(int i, int j, int[][] data, int[][] flag, int[] result) {
        // 越界返回
        if (i < 0 || i >= data.length) {
            return;
        }
        if (j < 0 || j >= data[0].length) {
            return;
        }
        // 遇0返回
        if (data[i][j] == 0) {
            return;
        }
        // 已访问返回
        if (flag[i][j] == 1) {
            return;
        }
        // 设置已访问
        flag[i][j] = 1;
        // 累计数+1
        result[3]++;
        // 团体开始则增加团体数
        if (result[2] == 0) {
            result[2] = 1;
            result[0]++;
        }
        // 递归相邻位置
        func(i - 1, j, data, flag, result);
        func(i + 1, j, data, flag, result);
        func(i, j - 1, data, flag, result);
        func(i, j + 1, data, flag, result);
        func(i - 1, j - 1, data, flag, result);
        func(i - 1, j + 1, data, flag, result);
        func(i + 1, j - 1, data, flag, result);
        func(i + 1, j + 1, data, flag, result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String firstLine = in.nextLine();
            String[] firstSplit = firstLine.split(",");
            int M = Integer.parseInt(firstSplit[0]);
            int N = Integer.parseInt(firstSplit[1]);
            if(M <= 0 || N <= 0) {
                return;
            }
            int[][] data = new int[M][N];
            int[][] flag = new int[M][N];
            for (int i = 0; i < M; i++) {
                String nextLine = in.nextLine();
                String[] nextSplit = nextLine.split(",");
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(nextSplit[j]);
                }
            }
            // num, max, isStart, count
            int[] result = new int[4];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 统计最大团体人数
                    if (result[3] > result[1]) {
                        result[1] = result[3];
                    }
                    // 重置开始标识和累计数
                    result[2] = 0;
                    result[3] = 0;
                    func(i, j, data, flag, result);
                }
            }
            System.out.print(result[0] + "," + result[1]);
        }
    }
}
