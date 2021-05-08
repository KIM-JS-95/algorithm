package KAKAO;

import java.util.*;

public class kakaonum1 {
    public static void main(String[] args) {
        String s = "23four5six7";

        solution(s);

    }

    public static int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        char[] Schar = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Schar[i] = s.charAt(i);
        }

        String arr1 = "";
        for (int i = 0; i < Schar.length; i++) {

            if (Schar[i] >= '0' && Schar[i] <= '9') {
                answer += Schar[i];
            } else {
                arr1 += Schar[i];

                if (map.containsKey(arr1)) {
                    Integer val = map.get(arr1);
                    arr1 = "";
                    answer += val;

                }
            }
        }
        System.out.println(" total answer: " + answer);

        int arr = Integer.parseInt(answer);
        return arr;
    }
}
