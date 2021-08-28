// 프로그래머스 위클리 첼린지 2주차
// https://programmers.co.kr/learn/courses/30/lessons/82612

// 이용금액이 3인 놀이기구를 4번 타고 싶은 고객이 현재 가진 금액이 20이라면,
// 총 필요한 놀이기구의 이용 금액은 30 (= 3+6+9+12) 이 되어 10만큼 부족하므로 10을 return 합니다.

package programers;

public class P82612 {
    public static void main(String[] args){
        int price = 3;
        int money = 20;
        int count = 4;

        System.out.println(solution(price, money, count));
    }

    public static long solution(int price, int money, int count) {
        long total = 0;
        for(int i=0; i<=count; i++){
            total += price * i;
        }

        return (total - money <= 0)? 0 : total - money;
    }
}
