package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697 {
    static int n,k;
    static int[] flag = new int[1000];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();

    if(n==k) {
        System.out.println(0);
    }else {
        BFS(n);
    }
    }

    private static void BFS(int start) {
        Queue<Integer> q =new LinkedList<>();
        q.offer(start);
        flag[start] =1;

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i=0; i<3; i++){
                int next;

                if(i==0){
                    next=temp+1;
                }else if(i==1){
                    next = temp -1;
                }else{
                    next = temp *2;
                }

                if(next==k){
                    System.out.println(flag[temp]);
                    return;
                }

                if(next >= 0 && next < flag.length && flag[next] ==0){
                    q.offer(next);
                    flag[next] = flag[temp]+1;
                }
            }
        }
    }
}
