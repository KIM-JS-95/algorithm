package ThisCoTe;

import java.util.Scanner;

public class GameDev {

    private static boolean[][] flag = new boolean[50][50];
    ;
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};
    public static int[][] arr = new int[50][50];
    public static int dir;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // 첫 위치
        int x = sc.nextInt();
        int y = sc.nextInt();
        dir = sc.nextInt();

        // 다음 위치
        int nx = 0;
        int ny = 0;

        // 방문 처리
        flag[x][y] = true;

        // 전체 맵 정보를 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int cnt = 1;
        int turn = 0;
        while (true) {

            turn_left();
            nx = x + dx[dir];
            ny = y + dy[dir];

            //방문한적 없다면 이동
            if (flag[nx][ny] == false && arr[nx][ny] == 0) {
                flag[nx][ny] = true;
                x = nx;
                y = ny;

                cnt++;
                turn = 0;
                continue;
            } else {  // 방문했다면 제자리에서 회전
                turn++;
            }

            if (turn == 4) {
                nx = x - dx[dir];
                ny = y - dy[dir];

                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else break;
            }
        }

        System.out.println(cnt);
    }

    public static void turn_left() {
        dir -= 1;
        if (dir == -1) dir = 3;
    }

}
