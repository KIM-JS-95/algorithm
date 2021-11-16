package BACKJOON;

import java.util.Scanner;

public class B2293 {
    private static int n, k;
    private static int[] arr, dp;
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        int n= sc.nextInt();
        int k= sc.nextInt();

        arr = new int[n + 1];
        dp = new int[k + 1];
        dp[0] = 1;

        // dp : 1,0,0,0,0,0,0,0,0,0
        for(int i = 1 ; i <= n; i++) {
            arr[i] = sc.nextInt();
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
