package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Queen {
    int x;
    int y;

    public Queen(int x, int y) {
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

public class B7562 {

    public static int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    public static int[] dy = {2, 2, 1, -1, -2, -2, -1, 1};
    public static boolean[][] flag;
    public static int[][] map;
    public static int n, endx, endy;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startx = Integer.parseInt(st.nextToken());
            int starty = Integer.parseInt(st.nextToken());

             st = new StringTokenizer(br.readLine());
            endx = Integer.parseInt(st.nextToken());
            endy = Integer.parseInt(st.nextToken());

            flag = new boolean[n][n];
            map = new int[n][n];

            map[startx][starty] = 0;
            bfs(startx, starty);
            System.out.println(map[endx][endy]);
        }
   }

    private static void bfs(int startx, int starty) {
        Queue<Queen> q = new LinkedList<>();
        if (startx == endx && starty == endy) {
            return;
        }
        flag[startx][starty] = true;
        q.offer(new Queen(startx, starty));

        while (!q.isEmpty()) {
            Queen node = q.poll();
            int x = node.getX();
            int y = node.getY();

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < map.length && ny <  map.length) {
                    if (!flag[nx][ny]) {
                        flag[nx][ny] = true;
                        map[nx][ny] = map[x][y] + 1;
                        q.offer(new Queen(nx, ny));
                    }
                }
            }
        }
    }
}
