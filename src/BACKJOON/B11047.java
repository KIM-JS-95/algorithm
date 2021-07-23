package BACKJOON;

import java.util.Scanner;

public class B11047 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt=0;
        int[] coins = new int[n];

        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }

        for(int i=n-1; i>=0; i--){
            if(coins[i] <= m){
                cnt += m/coins[i]; // 나눌 수 있는 코인의 개수
                m = m%coins[i]; // 나눈 후 나머지 금액 갱신
            }
            if(m<=0){
                break;
            }
        }
        System.out.print(cnt);
    }
}
