package BACKJOON;

import java.util.Scanner;
public class B1463 {

    static Integer[] dp;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        System.out.println(recur(N));

        print(N);
    }

    static int recur(int N) {
        if (dp[N] == null) {
            // 6으로 나눠지는 경우
            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;

            }
            // 3으로만 나눠지는 경우
            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;

            }
            // 2로만 나눠지는 경우
            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;

            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                dp[N] = recur(N - 1) + 1;
            }
        }

        return dp[N];
    }

    public static void print(int num){
        if(num==0) return;

        System.out.print(num +" ");
        if(num-1 >=0 && dp[num-1] == dp[num]-1){
            print(num-1);
        }else if(num%3==0 && dp[num/3] == dp[num]-1){
            print(num/3);
        }else if(num%2 ==0 && dp[num/2] == dp[num]-1){
            print(num/2);
        }
        return;
    }

}