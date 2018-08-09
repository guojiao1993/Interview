package netease;

import java.util.*;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            Map<String, Integer> member = new HashMap<>();
            Map<String, String> online2 = new TreeMap<>();
            Map<String, String> online1 = new TreeMap<>();
            Map<String, String> online0 = new TreeMap<>();
            Map<String, String> offline2 = new TreeMap<>();
            Map<String, String> offline1 = new TreeMap<>();
            Map<String, String> offline0 = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int value = in.nextInt();
                String key = in.next();
                member.put(key,value);
                switch (value) {
                    case 2: {
                        offline2.put(key, key);
                        break;
                    }
                    case 1: {
                        offline1.put(key, key);
                        break;
                    }
                    default: {
                        offline0.put(key, key);
                        break;
                    }
                }
            }
            int m = in.nextInt();
            for (int i = 0; i < m; i++) {
                String name = in.next();
                int action = in.nextInt();
                if (action == 1) {
                    switch (member.get(name)) {
                        case 2: {
                            offline2.remove(name);
                            online2.put(name, name);
                            break;
                        }
                        case 1: {
                            offline1.remove(name);
                            online1.put(name, name);
                            break;
                        }
                        default: {
                            offline0.remove(name);
                            online0.put(name, name);
                            break;
                        }
                    }
                } else {
                    switch (member.get(name)) {
                        case 2: {
                            online2.remove(name);
                            offline2.put(name, name);
                            break;
                        }
                        case 1: {
                            online1.remove(name);
                            offline1.put(name, name);
                            break;
                        }
                        default: {
                            online0.remove(name);
                            offline0.put(name, name);
                            break;
                        }
                    }
                }
            }
            Iterator<String> online2Iterator = online2.keySet().iterator();
            while (online2Iterator.hasNext()) {
                System.out.println(online2Iterator.next());
            }
            Iterator<String> online1Iterator = online1.keySet().iterator();
            while (online1Iterator.hasNext()) {
                System.out.println(online1Iterator.next());
            }
            Iterator<String> online0Iterator = online0.keySet().iterator();
            while (online0Iterator.hasNext()) {
                System.out.println(online0Iterator.next());
            }
            Iterator<String> offline2Iterator = offline2.keySet().iterator();
            while (offline2Iterator.hasNext()) {
                System.out.println(offline2Iterator.next());
            }
            Iterator<String> offline1Iterator = offline1.keySet().iterator();
            while (offline1Iterator.hasNext()) {
                System.out.println(offline1Iterator.next());
            }
            Iterator<String> offline0Iterator = offline0.keySet().iterator();
            while (offline0Iterator.hasNext()) {
                System.out.println(offline0Iterator.next());
            }
        }
    }
}