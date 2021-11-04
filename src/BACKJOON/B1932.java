package BACKJOON;

import java.util.Scanner;

public class B1932 {

    public static int[][] map;
    public static Integer[][] dp;
    public static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        dp = new Integer[n][n];

        for(int i=0; i<n; i++){
        for(int j=0; j<=i; j++){
            map[i][j] = sc.nextInt();
        }
        }

        for(int i=0; i<n; i++){
            dp[n-1][i] = map[n-1][i];
        }

        System.out.println(solution(0, 0));
    }

    public static int solution(int d, int w){

        if(d==n-1) return dp[d][w];

        if(dp[d][w]==null){
            dp[d][w] = Math.max(solution(d+1,w), solution(d+1, w+1)) + map[d][w];
        }

        return dp[d][w];
    }
}
