package bytedance;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            int size = in.nextInt();
            Map<Integer, Integer> data = new TreeMap<>();
            Map<Integer, Integer> result = new TreeMap<>();
            for (int i = 0; i < size; i++) {
                String nextLine = in.next();
                String[] split = nextLine.split(";");
                for (int j = 0; j < split.length; j++) {
                    String[] split1 = split[j].split(",");
                    data.put(Integer.parseInt(split1[0]),Integer.parseInt(split1[1]));
                }
            }
            Iterator<Map.Entry<Integer, Integer>> iterator = data.entrySet().iterator();
            int S = -1;
            int E = -1;
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();
                if(S == -1) {
                    S = next.getKey();
                    E = next.getValue();
                    continue;
                }
                Integer key = next.getKey();
                Integer value = next.getValue();
                if(E >= key) {
                    E = Math.max(E, value);
                } else {
                    result.put(S, E);
                    S = key;
                    E = value;
                }
            }
            if(S != -1) {
                result.put(S, E);
            }
            Iterator<Map.Entry<Integer, Integer>> iterator1 = result.entrySet().iterator();
            boolean isStart = true;
            while (iterator1.hasNext()) {
                if (isStart) {
                    isStart = false;
                } else {
                    System.out.print(";");
                }
                Map.Entry<Integer, Integer> next = iterator1.next();
                System.out.print(next.getKey() + "," + next.getValue());
            }
        }
    }
}
