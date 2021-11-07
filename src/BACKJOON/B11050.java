package BACKJOON;

import java.util.Scanner;

public class B11050 {

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        // 이항계수
        System.out.println(BC(n,k));
    }
    public static int BC(int n, int k){

        if(n==k || k==0){
            return 1;
        }
        return BC(n-1, k-1) + BC(n-1, k);
    }
}
