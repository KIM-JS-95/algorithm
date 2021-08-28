// 프로그래머스 위클리 첼린지 4주차
// https://programmers.co.kr/learn/courses/30/lessons/84325



package programers;

import java.util.HashMap;

public class P84325 {

    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#",
                "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA"};

        String[] lan = {"PYTHON", "C++", "SQL"};

        int[] pre = {7,5,5};
        System.out.println(solution(table, lan, pre));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String answer = "";
        // 언어 ,  배점 map에 입력
        for(int i=0 ; i<languages.length; i++){
            map.put(languages[i], preference[i]);
        }

        int max=0;
        for(int i=0; i<5; i++){
            String board[] = table[i].split(" ");
            int total = 0;

            // 각 행에 따른 language 찾기
            for(int j=0; j<table.length; j++){
                if(map.containsKey(board[j])){
                    total += (6-j) * map.get(board[j]);
                }
            }

            // 분야에 따른 최댓값 결정
            if(max < total){
                max = Math.max(max, total);
                answer = board[0];
            }
        }

        return answer;
    }
}
