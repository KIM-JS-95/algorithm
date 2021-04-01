package KAKAO;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PairCard {

    public static void main(String[] args) {

        int r = 1;
        int c = 0;
        int[][] board = {{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}};

        solution(board, r, c);
    }


    static final int INF = 987654321;
    static final int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] Board;

   public static int permutate(Point src) {
        int ret = INF;

        for (int num = 1; num <= 6; num++) {
            List<Point> card = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Board[i][j] == num) {
                        card.add(new Point(i, j, 0));
                    }
                }
            }

            if (card.isEmpty()) continue;

            int one = bfs(src, card.get(0)) + bfs(card.get(0), card.get(1)) + 2;

            int two = bfs(src, card.get(1)) + bfs(card.get(1), card.get(0)) + 2;

            for (int i = 0; i < 2; i++) {
                Board[card.get(i).row][card.get(i).col] = 0;
            }

            ret = Math.min(ret, one + permutate(card.get(1)));
            ret = Math.min(ret, two + permutate(card.get(0)));

            for (int i = 0; i < 2; i++) {
                Board[card.get(i).row][card.get(i).col] = num;
            }

        }

        if (ret == INF) return 0;
        return ret;
    }

    public static int bfs(Point src, Point dst) {
        boolean[][] visited = new boolean[4][4];

        Queue<Point> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (curr.row == dst.row && curr.col == dst.col)
                return curr.cnt;


            for (int i = 0; i < 4; i++) {
                int nr = curr.row + D[i][0];
                int nc = curr.col + D[i][1];

                if (nr < 0 || nr > 3 || nc < 0 || nc > 3) continue;


                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, curr.cnt + 1));
                }

                for (int j = 0; j < 2; j++) {
                    if (Board[nr][nc] != 0) break;
                    if (nr + D[i][0] < 0 || nr + D[i][0] > 3 || nc + D[i][1] < 0 || nc + D[i][1] > 3) {
                        break;
                    }
                    nr += D[i][0];
                    nc += D[i][1];
                }
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, curr.cnt + 1));
                }

            }
        }

        return INF;
    }


    public static int solution(int[][] board, int r, int c) {

        Board = board;
        System.out.println(permutate(new Point(r,c,0)));
        return permutate(new Point(r,c,0));
    }
}

class Point {
    Point(int r, int c, int t) {
        row = r;
        col = c;
        cnt = t;
    }

    int row, col, cnt;
}

