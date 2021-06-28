package ThisCoTe;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class CardSort {

    public static void main(String[] args){
        Queue<Integer> q = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        for(int i=0; i<n; i++){
            q.add(sc.nextInt());
        }

        int result=0;
        while(q.size() != 1){
            int one = q.poll();
            int two = q.poll();

            int sum = one+two;
            result +=sum;
            q.add(sum);
        }
        System.out.println(result);
    }

}
