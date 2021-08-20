package BACKJOON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class val {

    private int time;
    private char direction;

    public val(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return this.time;
    }

    public char getDirection() {
        return this.direction;
    }
}

class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class B3190 {

    public static int n, k, l;
    public static int[][] arr = new int[101][101]; // 맵 정보
    public static ArrayList<val> info = new ArrayList<>(); // 방향 회전 정보

    public static int dx[] = {0, 1, 0, -1};
    public static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        // 맵 정보(사과 있는 곳은 1로 표시)
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }

        // 방향 회전 정보 입력
        l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            info.add(new val(x, c));
        }

        System.out.println(simulate());
    }

    private static int simulate() {
        int x = 1;
        int y = 1;
        arr[x][y] = 2; // 2 존재 // 0 없음 // 1 사과
        int dir = 0;
        int time = 0;
        int index = 0;

        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (1 <= nx && nx <= n && 1 <= ny && ny <= n
                    && arr[nx][ny] != 2) {

                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                    Position prev = q.poll();
                    arr[prev.getX()][prev.getY()] = 0;
                }

                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                }
            } else {
                time += 1;
                break;
            }

            x = nx;
            y = ny;
            time += 1;
            if (index < l && time == info.get(index).getTime()) { // 회전할 시간인 경우 회전
                dir = turn(dir, info.get(index).getDirection());
                index += 1;
            }
        }
        return time;

    }

    private static int turn(int dir, char c) {
        if (c == 'L')
            dir = (dir == 0) ? 3 : dir - 1;
        else
            dir = (dir + 1) % 4;

        return dir;
    }
}

