package QUESTION;

import java.util.Scanner;
import java.util.Stack;

public class Flood_fill {
    static final int Max = 10;
    static int[][] D = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int N;
    static int[][] Board = new int[Max][Max];

    static class Point {
        int row;
        int col;

        Point(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Board[i][j] = sc.nextInt();
            }
        }
                int sRow = sc.nextInt();
                int sCol = sc.nextInt();
                int color = sc.nextInt();
                dfs(sRow, sCol, color);

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {

                System.out.print(Board[i][j] + " ");
            }
                    System.out.println();
        }
    }

    private static void dfs(int r, int c, int color) {
boolean[][] visit = new boolean[Max][Max];
        Stack<Point> stack= new Stack<>();
        stack.push(new Point(r,c));

        while(!stack.isEmpty()){
            Point curr = stack.pop();
            if(visit[curr.row][curr.col]) continue;

            visit[curr.row][curr.col] = true;
            Board[curr.row][curr.col] = color;

            for(int i=0; i<4; i++){
                int nr = curr.row + D[i][0];
                int nc = curr.col + D[i][1];

                if(nr<0 || nr > N-1 || nc <0 || nc > N-1) continue;
                if(visit[nr][nc])continue;
                if(Board[nr][nc] ==1) continue;
                stack.push(new Point(nr,nc));

            }
        }

    }
}
