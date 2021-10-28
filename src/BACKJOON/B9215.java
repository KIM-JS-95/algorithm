package BACKJOON;

import java.util.Scanner;

public class B9215 {

    public static int dp[][];
    public static char[] s1;
    public static char[] s2;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine().toCharArray();
        s2 = sc.nextLine().toCharArray();

        dp = new int[s1.length+1][s2.length+1];

        LCS(s1.length, s2.length);
    }

    public static void LCS(int x, int y){

        for(int i=1; i<=x; i++){
            for(int j=1; j<=y; j++){

                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }


        for(int i=1; i<= s1.length; i++){
            for(int j=1; j<=s2.length; j++){
                System.out.print(dp[j][i]+ " ");
            }
            System.out.println();
        }
        System.out.println(dp[s1.length][s2.length]);
    }
}