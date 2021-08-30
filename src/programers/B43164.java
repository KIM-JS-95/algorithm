// 프로그래머스 문제
// https://programmers.co.kr/learn/courses/30/lessons/43164

package programers;

import java.util.ArrayList;
import java.util.Collections;

// 모든 경로를 순회 하는 dfs 풀이
public class B43164 {
    public static boolean[] flag = new boolean[100];
    public static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args){
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        solution(tickets);
    }

    //public static int cnt=0;
    public static String[] solution(String[][] tickets) {
        int cnt =0;
        dfs("ICN","ICN",tickets, cnt);


        // 만일 가능 경로가 2개 이상이라면? -> 알파벳 순으로 정렬할 것
        Collections.sort(answer);
        //Convert to String[] from ArrayList type
        String[] answers =answer.get(0).split(" ");

        System.out.print(answer + " ");
        return answers;
    }

    public static void dfs(String start,String now, String[][] tickets, int count){

        if(count== tickets.length){
            answer.add(now);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(!flag[i] && tickets[i][0].equals(start)){
                flag[i]=true;
                dfs(tickets[i][1], now+" "+tickets[i][1], tickets ,count+1);
                flag[i]=false;
            }

        }
        return;
    }

}
