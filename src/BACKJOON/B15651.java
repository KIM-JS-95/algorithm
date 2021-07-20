package BACKJOON;

import java.util.Scanner;

public class B15651 {

    static int[] arr;
    static int N,M;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        arr = new int[M];

        dfs( 0);

    }

    public static void dfs(int depth) {

        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            dfs( depth + 1);
        }
    }

}
