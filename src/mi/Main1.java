package mi;

import java.util.ArrayList;
import java.util.Collections;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(solution("702 626;65098 84355 39226 94653 67498 49319 51022 80722 28539 12572"));
    }

    private static String solution(String line) {
        String[] split = line.split(";");
        String[] s1 = split[0].split(" ");
        String[] s2 = split[1].split(" ");
        int A = Integer.parseInt(s1[0]);
        int B = Integer.parseInt(s1[1]);
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < s2.length; i++) {
            l.add(Integer.parseInt(s2[i]));
        }
        Collections.sort(l);
        if(l.size() == 1) {
            return String.format("%.1f", String.valueOf(A));
        } else {
            double start = l.get(0);
            double end = start;
            double ans = A;
            for (int i = 1; i < l.size(); i++) {
                int n = l.get(i);
                // 扩建
                double r1 = ans - B * (end - start) / 2 + B * (n - start) / 2;
                // 新建
                double r2 = ans + A;
                if (r1 < r2) {
                    ans = r1;
                    end = n;
                } else {
                    ans = r2;
                    start = n;
                    end = n;
                }
            }
            return String.format("%.1f", ans);
        }
    }
}
