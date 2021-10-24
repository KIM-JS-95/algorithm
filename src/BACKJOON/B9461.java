package BACKJOON;

import java.util.Scanner;

public class B9461 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 테스트 수
        int t = sc.nextInt();

        int[] dp = new int[101];

        // 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        for(int j=4; j<=100; j++){
            dp[j]= dp[j-2] + dp[j-3];
        }

        // 데이터 초기화
        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
