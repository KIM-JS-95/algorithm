package BACKJOON;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class back_1665 {

    public static void main(String[] agrs) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        Queue<Integer> min = new PriorityQueue<>((o1, o2) -> o1 - o2);
        Queue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();

            if (min.size() == max.size())
                max.offer(t);
            else
                min.offer(t);
            if (!min.isEmpty() && !max.isEmpty()) {
                if (min.peek() < max.peek()) {
                    int temp = min.poll();
                    min.add(max.poll());
                    max.add(temp);
                }
            }
            sb.append(max.peek() + "\n");
        }
        System.out.println(sb);
    }
}
