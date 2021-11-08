package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B10830 {

    final static int MOD = 1000;
    public static int N;
    public static int[][] origin;	// A^1 일 때의 배열(초기 배열)

    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br  = new BufferedReader(input);


        // 입력 문장을 읽어온다.
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());	// 타입 주의

        origin = new int[N][N];


        /*
        1 2 3
        4 5 6
        7 8 9
        */

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(origin, B);


        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static int[][] pow(int[][] A, long exp) {

        if(exp == 1L) {
            return A;
        }

        // 지수를 절반으로 분할하여 재귀호출
        int[][] ret = pow(A, exp / 2);

        // 하위 재귀에서 얻은 행렬을 제곱해준다.
        ret = multiply(ret, ret);

        // 만약 지수가 홀수라면 마지막에  A^1 (origin)을 곱해준다.
        if(exp % 2 == 1L) {
            ret = multiply(ret, origin);
        }

        return ret;
    }

    public static int[][] multiply(int[][] o1, int[][] o2) {

        int[][] ret = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {

                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;	// 행렬 원소 연산이 끝나면 MOD로 나머지연산
                }
            }
        }
        return ret;
    }

}

