package BACKJOON;

import java.util.Scanner;

public class B2004 {

    public static int[]dp;

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        int N = sc.nextInt(); //25
        int M = sc.nextInt(); // 12


        long count5 = five_power_n(N) - five_power_n(N - M) - five_power_n(M);
        long count2 = two_power_n(N) - two_power_n(N - M) - two_power_n(M);

        System.out.println(Math.min(count5, count2));
    }

    static long five_power_n(long num) {
        int count = 0;

        while(num >= 5) {
            count += (num / 5);
            num /= 5;
        }
        return count;
    }

    // 2의 승수를 구하는 함수
    static long two_power_n(long num) {
        int count = 0;

        while(num >= 2) {
            count += (num / 2);
            num /= 2;
        }
        return count;
    }
}
