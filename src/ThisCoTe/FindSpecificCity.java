package ThisCoTe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindSpecificCity {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] d = new boolean[10000];
    public static int[] v = new int[10000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int value = sc.nextInt();
        int start = sc.nextInt();


        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        v[0] = 0;
        d[0] = true;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);

                if (d[next] == false) {
                    d[next] = true;
                    v[next] = v[now] + 1;
                    q.add(next);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (v[i] == value) {
                System.out.println(i);
            }
        }


    }
}
