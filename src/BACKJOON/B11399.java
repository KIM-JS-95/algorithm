package BACKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class B11399 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        int n = sc. nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int time = 0;
        int prev = 0;

        for (int i=0; i<n; i++){
        time += prev+arr[i];

        prev += arr[i];
        }

        System.out.print(time);

    }
}
