package BACKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class B1012 {
    static int a, b, c;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            a = sc.nextInt(); // 가로
            b = sc.nextInt(); // 세로
            c = sc.nextInt(); // 배추
            arr = new int[a][b];

            for (int k = 0; k < a; k++) {
                Arrays.fill(arr[k], 0);
            }

            for (int k = 0; k < c; k++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }

            for (int k = 0; k < a; k++) {
                for (int j = 0; j < b; j++) {
                    if (arr[k][j] != 0) {
                        DFS(k, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void DFS(int x, int y) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0||nx >= a || ny >= b ) {
                continue;
            }

            if (arr[nx][ny] == 0) {
                continue;
            }

            arr[nx][ny] = 0;
            DFS(nx, ny);
        }

    }

}
