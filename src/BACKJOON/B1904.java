package BACKJOON;

import java.util.Scanner;

public class B1904 {

    static int[] dp = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        int n = sc.nextInt();

        for (int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.print(fibo(n));
    }

    public static int fibo(int x) {
        if(dp[x] == -1) {
            dp[x] = (fibo(x - 1) + fibo(x - 2)) % 15746;
        }
        return dp[x];
    }
}
