package BACKJOON;

import java.util.Scanner;

public class B2749 {

    static long[][] origin = {{1, 1} , {1, 0}};
    final static long MOD = 1000000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long N = in.nextLong();

        long[][] A = {{1, 1} , {1, 0}};

        System.out.println(pow(A, N - 1)[0][0]);


    }

    public static long[][] pow(long[][] A, long exp) {

        if(exp == 1 || exp == 0) {
            return A;
        }

        // 지수를 절반으로 분할하여 재귀호출
        long[][] ret = pow(A, exp / 2);

        // 하위 재귀에서 얻은 행렬을 제곱해준다.
        ret = multiply(ret, ret);

        // 만약 지수가 홀수라면 마지막에  A^1 (origin)을 곱해준다.
        if(exp % 2 == 1L) {
            ret = multiply(ret, origin);
        }

        return ret;
    }

    public static long[][] multiply(long[][] o1,long[][] o2){
        long[][] ret = new long[2][2];

        ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
        ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
        ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
        ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;


        return ret;
    }

}
