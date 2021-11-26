// 피라미드 삼각형 문제와 유사

package ThisCoTe;

import java.util.Arrays;
import java.util.Scanner;

public class 금광 {
    public static Scanner sc = new Scanner(System.in);
    public static int n, m, cnt;
    static int[][] arr = new int[20][20];
    static int[][] dp = new int[20][20];

    public static int dx = 1;
    public static int[] dy = {-1, 0, 1};

    public static void main(String[] args) {

        int t = 1; // sc.nextInt();

        for (int i = 0; i < t; i++) {
            solution();
        }

    }

    private static void solution() {
        n = 3; //sc.nextInt();
        m = 4; //sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp = arr.clone();

        // 다이나믹 프로그래밍 진행
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int leftUp, leftDown, left;

                if (i == 0) leftUp = 0;
                else leftUp = dp[i - 1][j - 1];

                if (i == n - 1) leftDown = 0;
                else leftDown = dp[i + 1][j - 1];

                left = dp[i][j - 1];

                dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
              System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }


}
