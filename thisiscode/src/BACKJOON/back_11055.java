package BACKJOON;

import java.util.Scanner;

public class back_11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] array = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        dp[0] = array[0];

        int answer = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = array[i];
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j])
                    dp[i] = Math.max(dp[i], dp[j] + array[i]);
            }
            answer = Math.max(answer, dp[i]);
            System.out.println(dp[i]);
        }
        //System.out.println(answer);
    }

}

