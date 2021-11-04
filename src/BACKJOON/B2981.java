package BACKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class B2981 {

    public static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i]  =sc.nextInt();
        }

        Arrays.sort(arr);

        int val = arr[1] - arr[0];

        for(int i=2; i<n; i++){
            val = GDC(val , arr[i] - arr[i-1]);
        }


        for(int i=2; i<=val; i++){
            if(val % i ==0){
                System.out.println(i);
            }
        }

    }


    public static int GDC(int a, int b){

        while (b>0){
            int temp =a % b;
            a=b;
            b=temp;
        }
        return a;
    }

}
