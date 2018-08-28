package haoweilai;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //注意while处理多个case
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] ss = s.split(" ");
            int[] data = new int[111];
            for (int i = 0; i < ss.length; i++) {
                data[i] = Integer.valueOf(ss[i]);
            }
            int wholeMax = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < data.length && data[i] > 0; i++) {
                int max = data[i];
                if(map.containsKey(data[i]) && map.get(data[i]) > data[i]) {
                    max = map.get(data[i]);
                }
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> entry = iterator.next();
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();
                    if(key < data[i] &&  value + data[i] > max) {
                        max = value + data[i];
                    }
                }
                map.put(data[i], max);
                if(max > wholeMax) {
                    wholeMax = max;
                }
            }
            System.out.println(wholeMax);
        }
    }
}