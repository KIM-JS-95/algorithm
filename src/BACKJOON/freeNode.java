package BACKJOON;

import java.util.*;

public class freeNode {


    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] flag =new boolean[100];
    static boolean[] flagstack =new boolean[100];
    static int n, m, v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        for (int i = 0; i < m; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.get(a).add(b);
        }

        dfs(v);
        System.out.println();
        bfs(v);

    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        flagstack[start]=true;
        while (!stack.isEmpty()) {
            int now = stack.pop();
            System.out.print(now + " ");

            for (int i = 0; i < arr.get(now).size(); i++) {
                int y = arr.get(start).get(i);
                if (!flagstack[y]) {
                    flagstack[y] = true;
                    dfs(y);
                }
            }
        }

    }

    static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(start);
    flag[start]=true;

    while(!q.isEmpty()){
        int now = q.poll();
        System.out.print(now + " ");
        for(int i=0; i<arr.get(now).size(); i++){
            int y = arr.get(now).get(i);
            if(!flag[y]){
                q.offer(y);
                flag[y]=true;
            }
        }
    }
    }
}
