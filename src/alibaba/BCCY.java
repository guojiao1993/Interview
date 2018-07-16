package alibaba;

import java.util.Scanner;

/**
 * 内推编程测验
 * @date 2018-07-16
 */
public class BCCY {

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int calculate(String[] locations) {
        int xMax = 0;
        int yMax = 0;
        for (int i = 0; i < locations.length; i++) {
            String[] split = locations[i].split(",");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            if(x > xMax) {
                xMax = x;
            }
            if(y > yMax) {
                yMax = y;
            }
        }
        return (xMax + yMax) * 2;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while(num-- > 0){
            locations[index++] = scanner.nextLine();
        }
        System.out.println(calculate(locations));
    }
}