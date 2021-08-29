// 프로그래머스 문제 풀이
// https://programmers.co.kr/learn/courses/30/lessons/42578

package KAKAO;

import java.util.Arrays;
import static java.util.stream.Collectors.*;

public class 위장 {
    public static void main(String[] args) {
        String[][] s =
                {{"yellowhat", "headgear"},
                        {"bluesunglasses", "eyewear"},
                        {"green_turban", "headgear"}};

        System.out.println(solution(s));
    }

    public static int solution(String[][] clothes) {
    // stream 사용?
        return Arrays.stream(clothes)
                .collect(groupingBy(p-> p[1], mapping(p->p[0],counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x,y) -> x * (y+1))).intValue()-1;
    }


}
