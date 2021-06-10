package ALGORITHM;

import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {

    public static int INF = (int) 1e9;
    public static int[][] graph = new int[501][501];
    public static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (a == b) {
                    graph[a][b] = 0;
                }
            }
        }

        for (int i = 0; i <m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c= sc.nextInt();

            graph[a][b] = c;
        }

        floyd();

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY ");
                }
                // 도달할 수 있는 경우 거리를 출력
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }

    }

    private static int[][] floyd() {

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k]+ graph[k][b]);
                }
            }
        }

        return graph;
    }
}
