package guazi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new Main2().getClass().getResourceAsStream("Main2"));
        while (in.hasNext()) {
            int n = in.nextInt();
            HashMap<Integer, HashMap<Character, Integer>> map = new HashMap<>();
            int length = 0;
            for (int i = 0; i < n; i++) {
                String s = in.next();
                char[] c = s.toCharArray();
                length = c.length;
                for (int j = 0; j < c.length; j++) {
                    if (map.containsKey(j)) {
                        HashMap<Character, Integer> m = map.get(j);
                        if (m.containsKey(c[j])) {
                            m.put(c[j], m.get(c[j]) + 1);
                        } else {
                            m.put(c[j], 1);
                        }
                    } else {
                        HashMap<Character, Integer> m = new HashMap<>();
                        m.put(c[j], 1);
                        map.put(j, m);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            int num = (n + 1) / length;
            for (int i = 0; i < length; i++) {
                HashMap<Character, Integer> m = map.get(i);
                Iterator<Map.Entry<Character, Integer>> it = m.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Character, Integer> entry = it.next();
                    if (entry.getValue() < num) {
                        sb.append(entry.getKey());
                        break;
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}
