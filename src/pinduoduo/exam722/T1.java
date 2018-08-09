package pinduoduo.exam722;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意while处理多个case
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = (int) (Math.log(n+3) / Math.log(2));
            int a = (int) Math.pow(2, m) - 4;
            int b = (int) Math.pow(2, m + 1) - 4;
            int d = (b - a) / 4;
            if(a < n && n <= a + d) {
                System.out.println("Alice");
            } else if(a + d < n && n <= a + d * 2){
                System.out.println("Bob");
            } else if(a + d * 2 < n && n <= a + d * 3) {
                System.out.println("Cathy");
            } else {
                System.out.println("Dave");
            }
        }
    }
}
