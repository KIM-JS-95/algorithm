package ThisCoTe;

import java.util.Scanner;

public class Virus {
    public static int n, m, result;
    public static int[][] arr = new int[8][8];
    public static int[][] temp = new int[8][8];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(result);

    }

    public static void dfs(int cnt) {
        if (cnt == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = arr[i][j];
                }
            }

            // 벽을 세워도 바이러스는 마지막까지 힘을 내지
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2)
                        virus(i, j);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(temp[i][j]);
                }
                System.out.println();
            }
            System.out.println("======================");

            result = Math.max(result, Score());
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    cnt++;
                    dfs(cnt);

                    arr[i][j] = 0;
                    cnt--;
                }
            }
        }
    }

    private static int Score() {
        int score = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0)
                    score++;
            }
        }
        return score;
    }

    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};

    private static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx <= n && ny >= 0 && ny <= m) {
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }

    }
}
