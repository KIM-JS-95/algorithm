package BACKJOON;

import java.util.Scanner;

public class B10816 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] card = new int[20000001];

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            card[sc.nextInt() + 10000000]++;
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            sb.append(card[sc.nextInt() + 10000000] + " ");
        }
        System.out.print(sb.toString());
    }
}
