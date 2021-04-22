package BACKJOON;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class back_2178 {

    public static int N;
    public static int M;

    public static int[][] grid;
    public static boolean[][] flag;

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();


        grid = new int[N][M];
        flag = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String temp = sc.next();
            for (int j=0; j<M; j++) {
                grid[i][j] = temp.charAt(j) - 48; // ASCII Code 48~57 (숫자) 문자를 숫자로 변환
                 }
        }



        bfs(0,0);

    }

    public static void bfs(int x, int y){
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();

        row.add(x);
        col.add(y);

        while(!row.isEmpty() && !col.isEmpty()){
            x = row.poll();
            y = col.poll();
            flag[x][y] = true;

            for(int i=0; i< 4 ; i++){

            }
        }
    }


}

