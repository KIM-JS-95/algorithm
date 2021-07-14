package BACKJOON;


import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class B2178 {

    public static int N;
    public static int M;
    public static int[][] grid;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        sc.nextLine();
        grid = new int[N][M];


        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = temp.charAt(j) - '0';

            }
        }


        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<Dot> q = new LinkedList<>();
        int[] xd = {-1, 1, 0, 0};
        int[] yd = {0, 0, 1, -1};

        q.add(new Dot(x, y));

        while (!q.isEmpty()) {
            Dot d = q.poll();

            x = d.getX();
            y = d.getY();

            for (int i = 0; i < 4; i++) {
                int nextX = x + xd[i];
                int nextY = y + yd[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if(grid[nextX][nextY] == 0) continue;

                if (grid[nextX][nextY] == 1) {
                    grid[nextX][nextY] = grid[x][y] + 1;
                    q.add(new Dot(nextX, nextY));

                }
            }

        }
        return grid[N-1][M-1];
    }

}

class Dot {
    int x;
    int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
