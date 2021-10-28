package BACKJOON;

import java.util.Scanner;

public class B13305 {
    public static long[] dist;
    public static long[] node;
    public static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dist =new long[n-1];
        node =new long[n];

        for (int i = 0; i < n - 1; i++) {
            dist[i] = sc.nextLong();
        }

        for (int i = 0; i < n; i++) {
            node[i] = sc.nextLong();
        }

        solution(dist, node);
    }

    public static void solution(long[] dist, long[] node) {

        long sum = 0;
        long min = node[0];
        for (int i = 0; i < n - 1; i++) {

            if(node[i]<min){
                min = node[i];
            }

            sum += (min * dist[i]);
        }

        System.out.println(sum);
    }
}
