package ThisCoTe;

import java.util.Scanner;

public class Mine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               arr[i][j] = sc.nextInt();
                dp[i][j]=arr[i][j];
            }
        }

        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int leftUp, leftDown, left;

                if (i == 0) leftDown = 0;
                else leftDown = dp[i - 1][j - 1];

                if (i == n - 1) leftUp = 0;
                else leftUp = dp[i + 1][j - 1];

                left = dp[i][j - 1];
                dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i][m - 1]);
        }
        System.out.println(result);
        }
    }

