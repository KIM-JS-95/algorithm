package BACKJOON;

import java.util.Scanner;

public class B1010 {
    public static int dp[][] = new int[30][30];
    public static void main(String[] aegs){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();


        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            if (n < k) {
                // 이항계수
                System.out.println(combi(k, n));
            } else {
                // 이항계수
                System.out.println(combi(n, k));
            }
        }

        for(int i=0; i<30; i++){
            for(int j=0; j<30; j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }


    public static int combi(int n, int k){
       if(dp[n][k]>0){
           return dp[n][k];
       }

       if(n==k || k==0){
           return dp[n][k]=1;
       }

       return dp[n][k] = combi(n-1,k-1) + combi(n-1,k);
    }

}
