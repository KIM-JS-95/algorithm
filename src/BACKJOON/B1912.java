package BACKJOON;


import java.util.Scanner;

public class B1912 {
    public static int[] arr;
    public static Integer[] dp;
    public static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n];
        dp = new Integer[n];



        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // dp 가 null 값이면 재귀가 안됨
        dp[0] = arr[0];
        max = arr[0];

        solution(n - 1);

        for(Integer val : dp){
            System.out.print(val + " ");
        }

        System.out.println(max);
    }

    public static int solution(int n) {

        if (dp[n] == null) {
            dp[n] = Math.max(solution(n - 1) + arr[n], arr[n]);
            max = Math.max(dp[n], max);
        }

        return dp[n];
    }
}
