package BACKJOON;

import java.util.Scanner;

public class B10872 {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            System.out.println(fac(i));
        }
    }

    private static int fac(int n) {

        if(n<=1){
            return n;
        }else{
            return fac(n-1)*n;
        }
    }
}
