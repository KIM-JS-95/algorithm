package BACKJOON;


import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class back_2178 {

    public static int N;
    public static int M;
    public static int[][] grid;
    public static boolean[][] flag;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        sc.nextLine();
        grid = new int[N][M];
        flag = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = temp.charAt(j) - '0';
                flag[i][j] = false;
            }
        }

        flag[0][0] = true;
        bfs(0, 0);

        System.out.println(grid[N - 1][M - 1]);
    }

    public static void bfs(int x, int y) {

        int[] xd = {-1, 1, 0, 0};
        int[] yd = {0, 0, 1, -1};
        Queue<Dot> q = new LinkedList<Dot>();
        q.add(new Dot(x, y));

        while (!q.isEmpty()) {
            Dot d = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = d.x + xd[i];
                int nextY = d.y + yd[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                   // System.out.println(nextX +" "+nextY);
                    continue;
                }
                if (flag[nextX][nextY] || (grid[nextX][nextY] == 0) ) {
                    continue;
                }

                q.add(new Dot(nextX,nextY));

                grid[nextX][nextY] = grid[d.x][d.y]+1;

                for(int a=0; a< grid.length; a++){
                    for(int b=0; b< grid[a].length; b++){
                        System.out.printf("%5d",grid[a][b]);
                    }
                    System.out.println();
                }
                System.out.println();


                flag[nextX][nextY] = true;
            }
        }
    }

}

class Dot {
    int x;
    int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
