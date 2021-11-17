// 연쇄 행렬 곱셈
// Reference: https://www.geeksforgeeks.org/java-program-for-matrix-chain-multiplication-dp-8/

package BACKJOON;

import java.util.Scanner;

public class B11049 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt(); // 3
        int[][] arr = new int[size][2];
        int[][] dp=new int[size][size];

        for (int i = 0; i < size; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
          System.out.println(solution(dp,arr,size));
    }


    // DP 방식 풀이
    public static int solution(int[][] dp, int[][] arr, int n) {

        /* m[i, j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        // cost is zero when multiplying one matrix.

        // L is chain length.
        for(int i=1; i<n; i++) {
            for(int j=0; j<n-i; j++) {
                dp[j][j+i] = Integer.MAX_VALUE;
                for(int k=0; k<i; k++) {
                    int cost = dp[j][j+k] + dp[j+k+1][j+i] + arr[j][0] * arr[j+k][1] * arr[j+i][1];
                    dp[j][j+i] = Math.min(dp[j][j+i], cost);
                }
            }
        }

        return dp[0][n - 1];
    }

}
