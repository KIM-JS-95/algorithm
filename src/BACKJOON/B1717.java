package BACKJOON;

import java.util.Scanner;

public class B1717 {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
parent=new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int flag = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (flag == 0) {
                union(a, b);
            } else {
                if (isSame(a,b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }

    }

    static boolean isSame(int x, int y) {
        x = find(x);
        y = find(y);
        return x==y;
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
