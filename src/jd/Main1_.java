package jd;
import java.util.*;
public class Main1_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new Main1().getClass().getResourceAsStream("Main1"));
        Map<Integer, List<Integer>> map = new HashMap<>();
        int nums = scanner.nextInt();
        for (int i = 0; i < nums; i++) {
            // 节点数
            int nodes = scanner.nextInt();
            // 边数
            int edges = scanner.nextInt();
            for (int j = 1; j <= nodes; j++) {
                List<Integer> l = new ArrayList<>();
                l.add(j);
                map.put(j, l);
            }
            for (int j = 0; j < edges; j++) {
                int node1 = scanner.nextInt();
                int node2 = scanner.nextInt();
                map.get(node1).add(node2);
                map.get(node2).add(node1);
            }
            if (func(map)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            map.clear();
        }
    }
    public static boolean func(Map<Integer, List<Integer>> map) {
        int nodes = map.keySet().size();
        List<Integer> keys = new ArrayList<>();
        for (int i = 1; i <= nodes; i++) {
            keys.add(i);
        }
        while (keys.size() != 0) {
            int index = keys.get(0);
            List<Integer> tempList = new ArrayList<>();
            tempList.addAll(keys);
            List<Integer> judges = map.get(index);
            tempList.removeAll(judges);
            for (Integer key : tempList) {
                List<Integer> temp2 = map.get(key);
                temp2.retainAll(judges);
                if (temp2.size() != judges.size() - 1) {
                    return false;
                } else {
                    map.remove(key);
                    keys.remove(key);
                }
            }
            map.remove(index);
            keys.remove((Integer) index);
        }
        return true;
    }
}