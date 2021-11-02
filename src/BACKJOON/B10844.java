package BACKJOON;

import java.util.Scanner;

public class B10844 {

    public static long[][] dp;
    public static int n;
    public static long answer;
    public static long mod = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new long[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        recur(2);
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
             System.out.print(dp[i][j]);
            }
            System.out.println(2);
        }

    }

    public static long recur(int a) {

        if(a==n+1){
            for(int i=0; i<10; i++){
            answer+=dp[n][i];
            }
            return (answer % mod);
        }

        for (int j = 0; j < 10; j++) {
            if(j==0){
                dp[a][j]= dp[a - 1][j + 1] % mod;
            }else if(j==9){
                dp[a][j] = dp[a - 1][j - 1] % mod;
            }else{
                dp[a][j] = (dp[a - 1][j - 1] + dp[a - 1][j + 1]) % mod;
            }
    }
        return answer % mod;
    }
}
