package haoweilai;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new Main3().getClass().getResourceAsStream("Main3"));
        //注意while处理多个case
        while (in.hasNext()) {
            int[] array = new int[10];
            int[] result = new int[10];
            for (int i = 0; i < array.length; i++) {
                array[i] = in.nextInt();
            }
            func(array, 0, result);
        }
    }

    public static void func(int[] array, int index, int[] result) {
        if(index > 9) {
            for (int i = 0; i < result.length; i++) {
                if(result[i] != -1) {
                    System.out.print(result[i]);
                }
            }
            System.out.println();
            return;
        }
        if(array[index] == 0) {
            if(index == 9) {
                result[index] = -1;
                func(array, index + 1, result);
                result[index] = index;
                func(array, index + 1, result);
            } else {
                result[index] = index;
                func(array, index + 1, result);
                result[index] = -1;
                func(array, index + 1, result);
            }
        } else {
            result[index] = index;
            func(array, index + 1, result);
        }
    }
}