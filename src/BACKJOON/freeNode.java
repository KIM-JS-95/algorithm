package BACKJOON;
import java.util.*;

public class freeNode {
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        dp = new int[100][100];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 10000);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            dp[a][b] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int result = 0;
        // 각 학생을 번호에 따라 한 명씩 확인하며 도달 가능한지 체크
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] != 10000 || dp[j][i] != 10000) {
                    cnt += 1;
                }
            }
            if (cnt == n) {
                result += 1;
            }
        }
        System.out.println(result);
    }

    }

