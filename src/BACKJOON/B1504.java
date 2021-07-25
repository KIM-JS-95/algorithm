package BACKJOON;

import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int weight;
    private int distanse;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }


    public int getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }
}

public class B1504 {
    static ArrayList<ArrayList<Node>> a = new ArrayList<ArrayList<Node>>();
    static int INF = Integer.MAX_VALUE;
    static int N, E;
    static int[] dist; // 시작점에서 각 정점으로 가는 최단거리.
    static boolean[] check; // 방문 확인.


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();

        dist = new int[N + 1];
        check = new boolean[N + 1];


        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<Node>());
        }


        for (int i = 0; i < E; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();

            a.get(start).add(new Node(end, weight));
            a.get(end).add(new Node(start, weight));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);


        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.println(ans);
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.getEnd();

            if (!check[cur]) {
                check[cur] = true;

                for (int node =0; node<a.get(cur).size(); node++) {
                    if (!check[a.get(cur).get(node).getEnd()] && dist[a.get(cur).get(node).getEnd()] > dist[cur] + a.get(cur).get(node).getWeight()) {
                        dist[a.get(cur).get(node).getEnd()] = dist[cur] + a.get(cur).get(node).getWeight();
                        pq.add(new Node(a.get(cur).get(node).getEnd(), dist[a.get(cur).get(node).getEnd()]));
                    }
                }
            }
        }

        return dist[end];
    }
}
