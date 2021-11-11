package BACKJOON;

import java.math.BigInteger;
import java.util.Scanner;

public class B1676 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt=0;
        int n = sc.nextInt();

        while(n>=5){
            cnt += n/5;
            n /=5;
        }
        System.out.println(cnt);
    }
}
