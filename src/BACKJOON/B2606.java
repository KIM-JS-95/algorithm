package BACKJOON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2606 {
    public static boolean[] flag;
    public static ArrayList<ArrayList<Integer>> graph;
    static int cnt=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        flag = new boolean[n+1];
        graph = new ArrayList<>();

        for (int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        flag[1]=true;
        bfs(1);
        System.out.println(cnt);
    }

    public static void bfs(int start){
        Queue<Integer> q= new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int now=q.poll();

            for(int i=0; i<graph.get(now).size(); i++){
                int y = graph.get(now).get(i);
                if(!flag[y]){
                    cnt++;
                    flag[y]=true;
                    q.offer(y);
                   // bfs(y);
                }
            }
        }
    }
}
