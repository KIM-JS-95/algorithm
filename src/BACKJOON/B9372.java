package BACKJOON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B9372 {
    public static ArrayList<ArrayList<Integer>> list;
    public static boolean[] flag;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            list = new ArrayList<>();
            ans = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();

            flag = new boolean[10000];
            for (int j = 0; j < n + 1; j++) {
                list.add(new ArrayList<>());
            }

            for (int k = 0; k < m; k++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                list.get(a).add(b);
                list.get(b).add(a);
            }

            bfs(1);
            System.out.println(ans);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        flag[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < list.get(x).size(); i++) {
                int y = list.get(x).get(i);
                if (!flag[y]) {
                    ans++;
                    flag[y] = true;
                    q.offer(y);
                }
            }
        }
    }
}
