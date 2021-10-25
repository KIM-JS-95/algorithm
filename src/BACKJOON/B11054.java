package BACKJOON;

import java.util.*;

public class B11054 {


    public static Integer[] dp;
    public static Integer[] rdp;
    public static int[] a;
    public static int n, max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];

        dp = new Integer[n];
        rdp = new Integer[n];
        max = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }


        for (int i = 0; i < n; i++) {
            LIS(i);
            LDS(i);
        }
        int max = 0;

        for(int i=0; i<n; i++){
            max = Math.max(dp[i] + rdp[i], max);
        }
        System.out.println(max-1);

    }

    static int LIS(int N) {

        // 만약 탐색하지 않던 위치의 경우
        if (dp[N] == null) {
            dp[N] = 1; // 1로 초기화

            // N 이전의 노드들을 탐색
            for (int i = N - 1; i >= 0; i--) {
                // 이전의 노드 중 seq[N]의 값보다 작은 걸 발견했을 경우
                if (a[i] < a[N]) {
                    dp[N] = Math.max(dp[N], LIS(i) + 1);
                }
            }
        }
        return dp[N];
    }

    static int LDS(int N) {

        // 만약 탐색하지 않던 위치의 경우
        if (rdp[N] == null) {
            rdp[N] = 1; // 1로 초기화

            // N 이후의 노드들을 탐색
            for (int i = N + 1; i < rdp.length; i++) {
                // 이후의 노드 중 seq[N]의 값보다 작은 걸 발견했을 경우
                if (a[i] < a[N]) {
                    rdp[N] = Math.max(rdp[N], LDS(i) + 1);
                }
            }
        }
        return rdp[N];
    }
}

