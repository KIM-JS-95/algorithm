package BACKJOON;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B2447 {
    public static int n;
    public static char[][] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //27

        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], ' ');
        }

        star(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void star(int x, int y, int n) {
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    star(x + i * (n / 3), y + j * (n / 3), n / 3);
                }
            }
        }
    }
}
