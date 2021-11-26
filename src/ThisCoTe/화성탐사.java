package ThisCoTe;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Move implements Comparable<Move> {
    private int x;
    private int y;
    private int distance;

    public Move(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Move other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class 화성탐사 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] graph = new int[125][125];
    public static int[][] d = new int[125][125];
    public static int testCase;
    public static int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();

        for (int tc = 0; tc < testCase; tc++) {

            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                Arrays.fill(d[i], INF);
            }


            int x = 0;
            int y = 0;

            PriorityQueue<Move> q = new PriorityQueue<>();
            q.offer(new Move(0, 0, graph[x][y]));
            d[x][y] = graph[x][y];

            while (!q.isEmpty()) {
                Move move = q.poll();
                int dist = move.getDistance();

                x = move.getX();
                y = move.getY();

                if (d[x][y] < dist) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    int cost = dist + graph[nx][ny];

                    if (cost < d[nx][ny]) {
                        d[nx][ny] = cost;
                        q.offer(new Move(nx, ny, cost));
                    }
                }
            }
            System.out.println(d[n - 1][n - 1]);
        }
    }
}
