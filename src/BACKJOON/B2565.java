package BACKJOON;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B2565 {
    public static int[][] wire;
    public static Integer[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        dp = new Integer[n];
        wire = new int[n][2];

        for(int i = 0; i < n; i++) {
            wire[i][0] = in.nextInt();
            wire[i][1] = in.nextInt();
        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max =0;
        for (int i = 0; i < n; i++) {
            max = Math.max(solution(i), max);
        }


        System.out.println(n - max);
    }

    public static int solution(int N) {

        if (dp[N] == null) {
            dp[N] = 1;
            for (int i = N + 1; i < dp.length; i++) {
                if (wire[N][1] < wire[i][1]) {
                    dp[N] = Math.max(dp[N], solution(i) + 1);
                }
            }
        }
        return dp[N];
    }
}
