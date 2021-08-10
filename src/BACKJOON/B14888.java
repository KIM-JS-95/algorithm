package BACKJOON;

import java.util.ArrayList;
import java.util.Scanner;

public class B14888 {

    public static int plus, minus, multi, div;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;
    public static int n;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        plus = sc.nextInt();
        minus = sc.nextInt();
        multi = sc.nextInt();
        div = sc.nextInt();

        dfs(arr.get(0), 1);
        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int now, int i) {
        if (n == i) {
            max = Math.max(max, now);
            min = Math.min(min, now);
        } else {
            if (plus > 0) {
                plus--;
                dfs(now + arr.get(i), i + 1);
                plus++;
            }
            if (minus > 0) {
                minus--;
                dfs(now - arr.get(i), i + 1);
                minus++;
            }
            if (multi > 0) {
                multi--;
                dfs(now * arr.get(i), i + 1);
                multi++;
            }
            if (div > 0) {
                div--;
                dfs(now / arr.get(i), i + 1);
                div++;
            }
        }
    }
}

