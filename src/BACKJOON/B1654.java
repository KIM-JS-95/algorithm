package BACKJOON;

import java.util.Scanner;

public class B1654 {

    static int t;
    static long[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        t = sc.nextInt();
        list = new long[t];
        long max = 0;
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
            max = Math.max(max, list[i]);
        }

        long ans = 0;
        long start = 1;
        long end = max;
        while (start <= end) {
            long mid = (start + end) / 2;

            if (check(mid)) {
                start = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean check(long mid) {
        int cnt = 0;
        for (int i = 0; i < list.length; i++) {
            cnt += list[i] / mid;
        }
        return cnt >= t;
    }
}
