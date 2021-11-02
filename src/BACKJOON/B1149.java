package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1149 {
    public static int[][] map;
    public static int[][] dp;


    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][3];
        StringTokenizer st;
        for(int i = 0; i< N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++) {
            arr[i][0] += Math.min(arr[i-1][1] , arr[i -1][2]);
            arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);
        }

        for(int i = 0; i < N; i++) {
            System.out.print(arr[i][0] +" "+ arr[i][1]+" " +arr[i][2]);
            System.out.println();
        }
        
        System.out.println(Math.min(Math.min(arr[N-1][0], arr[N-1][1]), arr[N-1][2]));

    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        map = new int[n][3];
//        dp = new int[n][3];
//
//        for (int i = 0; i < n; i++) {
//
//            map[i][0] = sc.nextInt();
//            map[i][1] = sc.nextInt();
//            map[i][2] = sc.nextInt();
//        }
//
//        dp[0][0] = map[0][0]; // R
//        dp[0][1] = map[0][1]; // G
//        dp[0][2] = map[0][2]; // B
//
//
//        System.out.println(Math.min(find(n - 1, 0), Math.min(find(n - 1, 1), find(n - 1, 2))));

  //  }

    public static int find(int n, int color) {

        if (dp[n][color] == 0) {
            // R
            if (color == 0) {
                dp[n][0] = Math.min(find(n - 1, 1), find(n - 1, 2)) + map[n][0];
            }

            //G
            if (color == 1) {
                dp[n][1] = Math.min(find(n - 1, 0), find(n - 1, 2)) + map[n][1];
            }


            //B
            if (color == 2) {
                dp[n][2] = Math.min(find(n - 1, 0), find(n - 1, 1)) + map[n][2];
            }
        }
        return dp[n][color];
    }
}
