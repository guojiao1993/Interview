package haoweilai;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new Main1().getClass().getResourceAsStream("Main1"));
        //注意while处理多个case
        while (in.hasNext()) {
            String s = in.next();
            char[] chars = s.toCharArray();
            int count = 0;
            int temp = 0;
            for (int i = 0; i < chars.length; i++) {
                int num = chars[i] - 48;
                if(num % 3 == 0) {
                    count++;
                    temp = 0;
                } else {
                    temp += num;
                    if(temp % 3 == 0) {
                        count++;
                        temp = 0;
                    }
                }
            }
            System.out.println(count);
        }
    }
}