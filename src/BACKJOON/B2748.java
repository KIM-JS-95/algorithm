package BACKJOON;

import java.util.Scanner;

public class B2748 {

    static long[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        arr = new long[N + 1];

        for(int i = 0; i < N + 1; i++) {
            arr[i] = -1;
        }

        arr[0] = 0;
        arr[1] = 1;
        Fib(N);

        for(int i=0; i<arr.length; i++){
//            if(arr[i] >=1000000007){
//                System.out.println(i);
//                break;
//            }
            System.out.println(i + " = " +arr[i]);
        }
    }

    public static long Fib(int N) {
        if(arr[N] == -1) {
            arr[N] = Fib(N - 1) + Fib(N - 2);
        }
        return arr[N];
    }

}
