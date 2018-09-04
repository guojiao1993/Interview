package keep;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new keep.Main1().getClass().getResourceAsStream("Main1"));
        while (in.hasNext()) {
            String s = in.next();
            int k = in.nextInt();
            char[] chars = s.toCharArray();
            int i = 1;
            while (i * 3 * k <= chars.length){
                int j = (i - 1) * 3 * k;
                int l = j + k - 1;
                while (j < l) {
                    char c = chars[j];
                    chars[j] = chars[l];
                    chars[l] = c;
                    j++;
                    l--;
                }
                i++;
            }
            int m = (i - 1) * 3 * k;
            int n = 0;
            if(chars.length - m < k ) {
                n = chars.length - 1;
            } else {
                n = m + k - 1;
            }
            while (m < n) {
                char c = chars[m];
                chars[m] = chars[n];
                chars[n] = c;
                m++;
                n--;
            }
            System.out.println(String.valueOf(chars));
        }
    }
}
