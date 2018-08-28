package haoweilai;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int[] result = new int[x];
            for (int i = 0; i < x; i++) {
                result[i] = scanner.nextInt();
            }
            double sum = 0;
            for (int i = 0; i < result.length; i++) {
                sum = sum + result[i];
            }
            double d = sum / ((double) (x - y));
            DecimalFormat decimalFormat = new DecimalFormat("######0.00");
            System.out.println(decimalFormat.format(d));
        }
    }
}