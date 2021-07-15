package BACKJOON;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class tomato {
    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B7576 {
    public static int M, N;
    public static int map[][];
    public static boolean visit[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static Queue<tomato> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    q.offer(new tomato(i,j));
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void bfs() {
        int result = 0;
        int x, y;

        while (!q.isEmpty()) {
            tomato toma =  q.poll();
            x = toma.getX();
            y = toma.getY();
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int _x = x + dx[i];
                int _y = y + dy[i];
                if (_x >= 0 && _y >= 0 && _x < N && _y < M) {
                    if (map[_x][_y] == 0 && visit[_x][_y] == false) {
                        q.offer(new tomato(_x,_y));
                        visit[_x][_y] = true;
                        map[_x][_y] = map[x][y] + 1;
                        result = map[_x][_y];
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    result = -1;
                }
            }
        }
        if (result > 0) {
            System.out.println(result - 1);
        } else {
            System.out.println(result);
        }
    }


}

