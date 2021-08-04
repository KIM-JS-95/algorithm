package BACKJOON;

import java.util.Scanner;

public class B1300 {
    static long n,k,ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        long left = 1;
        long right = k;

        System.out.println(bi(left,right));
    }
    static long bi(long left, long right){

        int cnt=0;

        long mid = (left+right)/2;

        if(left>right) return ans;

        for(int i=1; i<=n; i++){
            cnt += Math.min(mid/i, n);
        }

        if(cnt<k){
            return bi(mid+1,right);
        }else{
            ans = mid;
            return bi(left,mid-1);
        }

    }
}
