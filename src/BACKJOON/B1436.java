package BACKJOON;

import java.util.Scanner;

public class B1436 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ans =0;
        int n =sc.nextInt();
        int cnt=0;

        while(cnt != n){
            ans++;
            if(String.valueOf(ans).contains("666")){
                cnt++;
            }
        }

        System.out.print(ans);
    }
}
