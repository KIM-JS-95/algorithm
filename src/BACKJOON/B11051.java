package BACKJOON;

import java.util.Scanner;

public class B11051 {
    public static int div = 10007;

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        // 이항계수
        System.out.println((fac(n) * mod((fac(n - k) * fac(k)) % div, div - 2)) % div);
    }

    // 모듈러 증명 and 페르마 소정리
    public static int mod(int a, int p) {
        int ret = 1;

        while (p > 0) {
            // 소수 판별
            if (p % 2 == 1) {

                ret *= a;
                p--;
                ret %= div;
            }
                a *= a;
                a %= div;
                p >>= 1;
            }
        return ret;
    }


    public static int fac(int n){

        if(n<=1){
            return 1;
        }
        return (n * fac(n-1)) % div;
    }
}
