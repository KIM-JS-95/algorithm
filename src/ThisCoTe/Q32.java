package ThisCoTe;

import java.util.Scanner;

public class Q32 {
    static int n;
    static int[][] dp = new int[500][500]; // 다이나믹 프로그래밍을 위한 DP 테이블 초기화

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int upLeft, up;

                if (j == 0) upLeft = 0;
                else upLeft = dp[i - 1][j - 1];

                if (j == i) up = 0;
                else up = dp[i - 1][j];

                dp[i][j] = dp[i][j] + Math.max(upLeft, up);
            }
        }

        int result =0;
        for(int i=0; i<n; i++){
            result = Math.max(result, dp[n-1][i]);
        }

        System.out.println(result);
    }
}
