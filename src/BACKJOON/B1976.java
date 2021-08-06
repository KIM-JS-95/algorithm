package BACKJOON;

import java.util.Scanner;

public class B1976 {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int flag = sc.nextInt();
                if (flag == 1) {
                    union(i, j);
                }
            }
        }

        int prev = sc.nextInt();
        for (int i = 0; i < m-1; i++) {
            if (!isSame(prev,sc.nextInt())){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static boolean isSame(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }


}
