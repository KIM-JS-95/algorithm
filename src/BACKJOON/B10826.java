package BACKJOON;

import java.math.BigInteger;
import java.util.Scanner;


public class B10826 {
    static BigInteger[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        dp = new BigInteger[n+1];

        if(n == 0 || n == 1) {
            System.out.println(n);
            return;
        }

        dp[0] = BigInteger.ZERO;
        dp[1] =  BigInteger.ONE;
        dp[2] =  BigInteger.ONE;

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1].add(dp[i-2]); // *
        }
        System.out.println(dp[n]);

    }
}
