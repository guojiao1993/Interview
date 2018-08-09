package pinduoduo.exam722;

import java.util.Arrays;
import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意while处理多个case
        while (in.hasNextInt()) {
            String n = in.nextLine();
            String[] split = n.split(" ");
            int[] w = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                w[i] = Integer.parseInt(split[i]);
            }
            Arrays.sort(w);
            boolean[] z = new boolean[w.length];
            int sn = w.length;
            int num = 0;
            int h = 0;
            while (sn != 0) {
                for (int i = w.length - 1; i >= 0; i--) {
                    if(!z[i]) {
                        h = w[i];
                        z[i] = true;
                        sn--;
                        break;
                    }
                }
                int s = 300 - h;
                for (int i = 0; i < w.length; i++) {
                    if(!z[i]) {
                        if(w[i] <= s) {
                            z[i] = true;
                            s -= w[i];
                            sn--;
                        } else {
                            break;
                        }
                    }
                }
                num++;
            }
            System.out.println(num);
        }
    }
}
