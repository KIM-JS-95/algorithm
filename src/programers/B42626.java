package programers;


import java.util.*;
public class B42626 {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>();
        int answer = 0;

        //큐에 스텍 쌓기
        for(int val : scoville)
            Q.add(val);

        while(Q.size()>1 && Q.peek()<K){
            int first = Q.poll();
            int second = Q.poll();

            int max = first + (second *2);
            Q.add(max);
            answer++;

            if(Q.size()<=1 || Q.peek() <K)
                answer=-1;
        }



        return answer;
    }
}

