package beike;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
            sum += A[i];
            if(A[i] < min) {
                min = A[i];
            }
        }
        System.out.println(sum - min);
    }
}
