package ALGORITHM;

import java.util.Scanner;
import java.util.Stack;

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
        DFS_stack(0);
    }

    public static void DFS(int node) {
        flag[node] =true;
        System.out.print(node + " ");

        for(int i=0; i<N; i++)
        if(!flag[i] && Graph[node][i]!=0){
            DFS(i);
        }
    }

    public static void DFS_stack(int node) {
      boolean[] visit = new boolean[10];

        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            int curr = stack.pop();

            if(visit[curr]) continue;

            visit[curr] = true;
            System.out.print(curr + " ");

            for(int i = 0; i<N; i++){
                if(!visit[i] && Graph[curr][i]!= 0){
                    stack.push(i);
                }
            }
        }
    }


}
