package BACKJOON;


import java.util.Scanner;

public class B2580 {
    static int[][] arr = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        // dfs 형식으로 풀이
        sudoku(0, 0);
    }

    private static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
        }


        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            // 출력 뒤 시스템을 종료한다.
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possible(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col + 1);
                }
            }

            arr[row][col] = 0;
            return;
        }
        sudoku(row, col + 1);
    }

    private static boolean possible(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            if (arr[j][col] == value) {
                return false;
            }
        }

        int set_row = (row/3)*3;
        int set_col = (col/3)*3;


            for(int j=set_col;j<set_col+3; j++){
                for(int i=set_row; i<set_row+3; i++){
                if(arr[i][j]==value){
                    return false;
                }
            }
        }
        return true;
    }

}
