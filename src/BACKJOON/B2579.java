package BACKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class B2579 {

    public static Integer[] dp;
    public static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n + 1];
        dp = new Integer[n + 1];


        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if(n>1){
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(n));

    }

    public static int find(int n) {

        if (dp[n]== null) {
            dp[n] = arr[n] + Math.max(find(n - 3) + arr[n - 1], find(n - 2));
        }
        return dp[n];
    }
}
