package BACKJOON;

import java.util.Scanner;

class Point{
    int row;
    int col;
    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class back_2178 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] arr =new char[N][M];
        boolean[][] flag = new boolean[N][M];

        for(int i=0; i<N; i++){
            String temp = sc.next();
            for(int j=0; j<M; j++){
                arr[i][j] = temp.charAt(j);
            }
        }



    }
}
