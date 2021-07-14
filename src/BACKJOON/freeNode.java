package BACKJOON;


import java.util.*;

class Edge implements Comparable<Edge> {

    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class freeNode {
    public static void main(String args[]) {

        int[] deposit = {500, 1000, -300, 200, -400, 100, -100};

        solution(deposit);
    }

    public static int[] solution(int[] deposit) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
       // Arrays.sort(deposit);

        int temp = 0;
        int sum = 0;
        for (int i = 0; i < deposit.length; i++) {
            if (deposit[i] > 0) {
                stack.add(deposit[i]);
            } else {
                stack2.add(deposit[i]);
            }
        //    System.out.println(stack);
      //  System.out.println(stack2);

            if(stack2.size()>0) {
                while (!stack2.isEmpty()) {
                    temp = stack2.pop();
                    sum = stack.pop();
                    // System.out.println(sum);
                    if (sum < Math.abs(temp)) {
                        while (sum < Math.abs(temp)) {
                            sum += stack.pop();
                        }
                        sum += temp;
                        stack.add(sum);
//                        if (sum != 0) {
//                            stack.add(sum);
//                        }
                    }
                }
            }
            System.out.println(stack);
        }
//        System.out.println(stack);
//        System.out.println(stack2);

        //                int temp=stack.pop();
//                if(temp<Math.abs(deposit[i])) {
//                    while (temp<Math.abs(deposit[i])){
//                        temp += stack.pop();
//                    }
//                    stack.add(temp + deposit[i]);
//                }else{
//                    int sum =temp + deposit[i];
//                    if(sum !=0)
//                        stack.add(sum);
//                }

        int[] answer = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            answer[i] = stack.pop();
            i++;
        }
        return answer;
    }

}
