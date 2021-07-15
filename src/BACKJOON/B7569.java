package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tree {
    int x;
    int y;
    int z;

    public Tree(int z, int x, int y) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}

public class B7569 {

    public static int M, N, T;
    public static int map[][][];
    public static boolean visit[][][];
    static int dx[] = {-1, 1, 0, 0, 0, 0};
    static int dy[] = {0, 0, -1, 1, 0, 0};
    static int dz[] = {0, 0, 0, 0, -1, 1};
    static Queue<Tree> q = new LinkedList<Tree>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        T = sc.nextInt();

        map = new int[T][N][M];
        visit = new boolean[T][N][M];

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = sc.nextInt();
                    if (map[i][j][k] == 1) {
                        q.offer(new Tree(i, j, k));
                    }
                }
            }
        }

        bfs();

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.print(map[i][j][k] + " ");
                }
                System.out.println();
            }
        }
    }


    public static void bfs() {
        int result = 0;
        int x, y, z;

        while (!q.isEmpty()) {
            Tree toma = q.poll();
            x = toma.getX();
            y = toma.getY();
            z = toma.getZ();
            visit[z][x][y] = true;

            for (int i = 0; i < 6; i++) {
                int _x = x + dx[i];
                int _y = y + dy[i];
                int _z = z + dz[i];
                if (_x >= 0 && _y >= 0 && _z >= 0 && _x < N && _y < M && _z < T) {
                    if (map[_z][_x][_y] == 0 && visit[_z][_x][_y] == false) {
                        q.offer(new Tree(_z, _x, _y));
                        visit[_z][_x][_y] = true;
                        map[_z][_x][_y] = map[z][x][y] + 1;
                        result = map[_z][_x][_y];
                    }
                }
            }
        }
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++)
                    if (map[i][j][k] == 0) {
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
