package BACKJOON;

import java.util.Scanner;

public class back_9251 {

    public static int dp[][];
    public static char[] s1;
    public static char[] s2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine().toCharArray();
        s2 = sc.nextLine().toCharArray();

        dp = new int[s1.length + 1][s2.length + 1];

        LCS(s1.length, s2.length);

//        for(int i=0; i< dp.length; i++){
//            for(int j=0; j< dp[i].length; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
    }

    public static void LCS(int x, int y) {

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {

                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[s1.length][s2.length]);
    }
}