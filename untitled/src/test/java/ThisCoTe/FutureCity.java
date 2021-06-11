package ThisCoTe;

import java.util.Arrays;
import java.util.Scanner;

public class FutureCity {

    public static int[][] graph = new int[101][101];
    public static int INF = (int)1e9;
    public static int n,m,k,x;

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        n =sc.nextInt();
        m = sc.nextInt();

        for(int i=0; i<n; i++){
            Arrays.fill(graph[i], INF);
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        floyd();

        x = sc.nextInt();
        k = sc.nextInt();

        print();

    }

    public static void floyd(){
        for(int k=1; k<=n; k++){
            for(int a=1; a<=n; a++){
                for(int b=1; b<=n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);
                }
            }
        }

    }

    public static void print(){
        int distance = graph[1][k] + graph[k][x];

        if(distance >=INF){
            System.out.println(-1);
        }else{
            System.out.println(distance);
        }
    }
}
