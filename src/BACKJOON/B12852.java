package BACKJOON;

import java.util.Scanner;

public class B12852 {

    public static Integer[] dp;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp = new Integer[n + 1];
        dp[0] = dp[1] = 0;

        recue();
    }


    public static void recue() {

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+1;

            if(i%3==0){
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
            if(i%2==0){
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
        }
        System.out.println(dp[n]);
        print(n);
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
