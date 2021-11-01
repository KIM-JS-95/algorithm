package BACKJOON;

import java.util.Scanner;

public class B1149 {
    public static int[][] map;
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        map = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {

            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
            map[i][2] = sc.nextInt();
        }

        dp[0][0] = map[0][0]; // R
        dp[0][1] = map[0][1]; // G
        dp[0][2] = map[0][2]; // B


        System.out.println(Math.min(find(n - 1, 0), Math.min(find(n - 1, 1), find(n - 1, 2))));

    }

    public static int find(int n, int color) {

        if (dp[n][color] == 0) {
            // R
            if (color == 0) {
                dp[n][0] = Math.min(find(n - 1, 1), find(n - 1, 2)) + map[n][0];
            }

            //G
            if (color == 1) {
                dp[n][1] = Math.min(find(n - 1, 0), find(n - 1, 2)) + map[n][1];
            }


            //B
            if (color == 2) {
                dp[n][2] = Math.min(find(n - 1, 0), find(n - 1, 1)) + map[n][2];
            }
        }
        return dp[n][color];
    }
}
