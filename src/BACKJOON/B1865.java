package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1865 {
    static int n;
    static int m;
    static int w;
    static int dis[];
    static ArrayList<edge>[] road;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); //  테스트케이스의 개수 TC (1 ≤ TC ≤ 5)

        for(int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 지점의 수 N (1 ≤ N ≤ 500)
            m = Integer.parseInt(st.nextToken()); // 도로의 개수 M (1 ≤ M ≤ 2500)
            w = Integer.parseInt(st.nextToken()); // 웜홀의 개수 W (1 ≤ W ≤ 200)

            dis = new int[n+1];
            Arrays.fill(dis, 987654321);
            road = new ArrayList[n+1];

            for(int j = 0; j < n+1; j++) {
                road[j] = new ArrayList<>();
            }

            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                road[a].add(new edge(b, c));
                road[b].add(new edge(a, c));
            }

            for(int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                road[a].add(new edge(b, -c));
            }

            if(bellmanFord()) System.out.println("YES");
            else System.out.println("NO");

        }


    }

    static boolean bellmanFord() {
        dis[1] = 0;

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < road.length; j++) {
                for(edge next: road[j]) {
                    if(dis[j] + next.time < dis[next.node]) {
                        dis[next.node] = dis[j] + next.time;
                    }
                }
            }
        }

        for(int j = 1; j < road.length; j++) {
            for(edge next: road[j]) {
                if(dis[j] + next.time < dis[next.node]) {
                    return true;
                }
            }
        }
        return false;
    }

    static class edge{
        int node; // 노드
        int time; // 걸리는 시간

        edge(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

}