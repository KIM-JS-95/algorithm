package BACKJOON;

import java.util.Scanner;

public class ConbineFile {

    public static int[] d = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];


        for (int i = 2; i <= n; i++) {
            arr[i] = sc.nextInt();
            d[i] = Math.min(d[i - 1], d[i - 2] + arr[i]);
        }
for(int val : d)
    System.out.print(val + " ");

    }
}
