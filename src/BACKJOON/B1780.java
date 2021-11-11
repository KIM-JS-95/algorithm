package BACKJOON;

import java.util.Scanner;

public class B1780 {
    public static int[][] arr;
    public static int g = 0;
    public static int w = 0;
    public static int b = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        solution(0,0,n);
        System.out.println(g + "\n" + w + "\n" + b);
    }

    public static void solution(int row, int col, int size) {

        if (check(row, col, size)) {
            if(arr[row][col] == -1) {
                g++;
            }
            else if(arr[row][col] == 0) {
                w++;
            }
            else {
                b++;
            }

            return;
        }

        int newsize = size / 3;

        solution(row, col, newsize);
        solution(row, col+newsize, newsize);
        solution(row, col+2*newsize, newsize);

        solution(row+newsize, col, newsize);
        solution(row+newsize, col+newsize, newsize);
        solution(row+newsize, col+2*newsize, newsize);

        solution(row+2*newsize, col, newsize);
        solution(row+2*newsize, col+newsize, newsize);
        solution(row+2*newsize, col+2*newsize, newsize);

    }

    public static boolean check(int row, int col, int size) {
        int color = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
