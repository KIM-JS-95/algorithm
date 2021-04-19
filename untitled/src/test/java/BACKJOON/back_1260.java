package BACKJOON;

import java.io.*;
import java.util.*;

public class back_1260 {

    static int[][] arr;
    static boolean[] visit;
    static int N;
    static int M;
    static int V;

    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br1.readLine());

        N = Integer.parseInt(st.nextToken()); //node
        M = Integer.parseInt(st.nextToken()); // edge
        V = Integer.parseInt(st.nextToken()); //start

        arr = new int[1001][1001];
        visit = new boolean[1001];

        for (int i = 0; i < M; i++) {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[x][y] = arr[y][x]=1;
        }
        dfs(V);

        visit = new boolean[1001];
        System.out.println();

        bfs();
    }

    public static void dfs(int V) {

        visit[V] = true;
        System.out.print(V + " ");

        for(int i=1; i<=N; i++){
            if(arr[V][i] ==1 && visit[i]== false){
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer>  queue = new LinkedList<>();

        queue.offer(V);
        visit[V] = true;
        System.out.print(V + " ");

        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(int i=1; i<=N; i++){
                if(arr[temp][i]==1 && visit[i]==false){
                    queue.offer(i);
                    visit[i]=true;

                    System.out.print(i + " ");
                }
            }
        }
    }
}
