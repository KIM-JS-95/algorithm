package ALGORITHM;

import java.util.Scanner;

public class DFS {
    static int[][] Graph = new int[10][10];
    static boolean[] flag = new boolean[10];
    static int N;
    static int E;

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();

        for(int i=0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            Graph[u][v] = Graph[v][u] =1;
        }
        DFS(0);
    }

    public static void DFS(int node) {
        flag[node] =true;
        System.out.print(node + " ");

        for(int i=0; i<N; i++)
        if(!flag[i] && Graph[node][i]!=0){
            DFS(i);
        }
    }




}
