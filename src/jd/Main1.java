package jd;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new Main1().getClass().getResourceAsStream("Main1"));
        while (in.hasNext()) {
            int T = in.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < T; i++) {
                int N = in.nextInt();
                int M = in.nextInt();
                HashMap<Integer, ArrayList<Integer>> record = new HashMap<>();
                for (int j = 0; j < M; j++) {
                    int X = in.nextInt();
                    int Y = in.nextInt();
                    int min = Math.min(X, Y);
                    int max = Math.max(X, Y);
                    if (record.containsKey(min)) {
                        ArrayList<Integer> t = record.get(min);
                        t.add(max);
                        record.put(min, t);
                    } else {
                        ArrayList<Integer> t = new ArrayList<>();
                        t.add(max);
                        record.put(min, t);
                    }
                }
                boolean judge = true;
                ArrayList<ArrayList<Integer>> set = new ArrayList<>();
                for (int j = 1; j <= N; j++) {
                    int joins = 0;
                    for (int k = 0; k < set.size(); k++) {
                        ArrayList<Integer> t = set.get(k);
                        int l = 0;
                        for (; l < t.size(); l++) {
                            Integer m = t.get(l);
                            int min = Math.min(j, m);
                            int max = Math.max(j, m);
                            if (!record.get(min).contains(max)) {
                                joins++;
                                t.add(j);
                                break;
                            }
                        }
                    }
                    if(joins == 0) {
                        ArrayList<Integer> t = new ArrayList<>();
                        t.add(j);
                        set.add(t);
                        continue;
                    }
                    if(joins > 1) {
                        judge = false;
                        break;
                    }
                }
                if(judge) {
                    sb.append("Yes\n");
                } else {
                    sb.append("No\n");
                }
            }
            System.out.print(sb.toString());
        }
    }
}
