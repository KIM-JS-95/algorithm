// 7 8
// 1 2
// 1 5
// 2 3
// 2 6
// 3 4
// 4 7
// 5 6
// 6 4


package ThisCoTe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologySort {

    public static int v, e;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] indegree = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            indegree[b] += 1;
        }

        topology();
    }

    private static void topology() {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll(); // 꺼낸다.
            result.add(now);

            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)] -= 1;

                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        for(int i=0; i< result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }

}
