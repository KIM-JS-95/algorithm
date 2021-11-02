package BACKJOON;


import java.util.Scanner;

public class B2156 {

    public static Integer[] dp;
    public static int[] wine;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dp = new Integer[n+1];
        wine = new int[n+1];

        for(int i=1; i<=n; i++){
            wine[i] = sc.nextInt();
        }

        // 이건 뭐지?
        dp[0] = wine[0];
        dp[1] = wine[1];

        if(n>1){
            dp[2] = wine[1] + wine[2];
        }


        System.out.println(valuemax(n));

    }

    public static int valuemax(int n){

        if(dp[n]==null){
            dp[n] = Math.max(
                    Math.max(valuemax(n - 3) + wine[n - 1], valuemax(n - 2)) +wine[n]
                    ,valuemax(n-1));
        }
        return dp[n];
    }
}
