package netease;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class T3 {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String pre = "2000-01-0";
        Map<Long, Long> record = new TreeMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < T; i++) {
            int K = in.nextInt();
            for (int j = 0; j < K; j++) {
                int W = in.nextInt();
                int M = in.nextInt();
                for (int k = 0; k < M; k++) {
                    String time = in.next();
                    String[] split = time.split("-");
                    String begin = pre + W + " " + split[0];
                    String end = pre + W + " " + split[1];
                    Date beginDate = sdf.parse(begin);
                    Date endDate = sdf.parse(end);
                    long beginTime = beginDate.getTime();
                    long endTime = endDate.getTime();
                    record.put(beginTime, endTime - beginTime);
                }
            }
            // 在末尾插入开头的7天后的最大值，在开头插入末尾的7天前的最小值
            Iterator<Map.Entry<Long, Long>> iterator = null;
            iterator = record.entrySet().iterator();
            Map.Entry<Long, Long> next = iterator.next();
            Long begin = next.getKey();
            Long beginValue = next.getValue();
            while (iterator.hasNext()) {
                next = iterator.next();
            }
            Long last = next.getKey();
            Long lastValue = next.getValue();
            record.put(begin + 7 * 24 * 3600 * 1000, beginValue);
            record.put(last - 7 * 24 * 3600 * 1000, lastValue);
            int C = in.nextInt();
            long[] result = new long[C];
            for (int j = 0; j < C; j++) {
                int W = in.nextInt();
                String time = in.next();
                String now = pre + W + " " + time;
                Date nowDate = sdf.parse(now);
                long nowTime = nowDate.getTime();
                iterator = record.entrySet().iterator();
                Map.Entry<Long, Long> b = iterator.next();
                while (iterator.hasNext()) {
                    Map.Entry<Long, Long> e = iterator.next();
                    Long bTime = b.getKey();
                    Long eTime = e.getKey();
                    if(nowTime >= bTime && nowTime <= eTime) {
                        if(nowTime - bTime <= b.getValue()) {
                            result[j] = 0;
                            break;
                        } else {
                            result[j] = (eTime - nowTime) / 1000;
                            break;
                        }
                    } else {
                        b = e;
                    }
                }
            }
            for (int j = 0; j < C; j++) {
                System.out.println(result[j]);
            }
        }
    }
}