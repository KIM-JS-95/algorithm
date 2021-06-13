package ThisCoTe;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class NumCardplay {
    public static int[] temp = new int[3];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        for (int i = 0; i < N; i++) {
            Arrays.sort(arr[i]);
            temp[i] = arr[i][0];
        }

//        for(int val :temp)
//        System.out.println(val);

        int answer = Arrays.stream(temp).max().getAsInt();
        System.out.println(answer);
    }
}
