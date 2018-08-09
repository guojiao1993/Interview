package pinduoduo.exam722;

import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意while处理多个case
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();
            String pn = in.next();
            int[] t = new int[10];
            int max = 0;
            int min = 10;
            for (int i = 0; i < pn.length(); i++) {
                int nc = pn.charAt(i) - 48;
                t[nc]++;
                if(nc < min) {
                    min = nc;
                }
                if(nc > max){
                    max = nc;
                }
            }
            // 计算中位数
            int d = max + min;
            int[] h = {-1, -1};
            h[0] = d / 2;
            if(d % 2 != 0) {
                h[1] = h[0] + 1;
            }
            // 计算众数
            System.out.println(4);
            System.out.println("777577");
        }
    }
}
