package KAKAO;

// 프로그래머스 카카오 인턴쉽 문제 https://programmers.co.kr/learn/courses/30/lessons/81301
// 1. 영어, 숫자 해쉬맵으로 구성
// 2. String temp를 선언아여 반복문으로 알파벳을 더함 (숫자는 아스키 코드로 범위를 선언하여 필터링함)
// 3. temp를 get(temp)로 Value 값을 호출하여 answer 변수에 저장
// 4. answer변수를 Integer로 변환하여 출력


import java.util.*;

public class 숫자문자열과영단어 {
    public static void main(String[] args) {
        String s = "one4seveneight";

        solution(s);
    }

    public static int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        String answer = "";


        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("zero", 0);

        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            char num = s.charAt(i);

            if (num >= 48 && num <= 57) {
                answer = answer + num + "";
                continue;
            }

            temp = temp + s.charAt(i);
            if (map.containsKey(temp)) {
                answer = answer + map.get(temp);
                temp = "";
            }
            System.out.print(temp + " ");
        }

        int ans = Integer.parseInt(answer);
        return ans;
    }
}
