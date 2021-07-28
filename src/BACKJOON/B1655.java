package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q= new PriorityQueue<>((o1, o2) -> o2-o1);

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int t = Integer.parseInt(br.readLine());;
            if(t==0){
                q.offer(t);
                System.out.println(q.poll());
            }else{
                q.offer(t);
            }
        }
    }
}
