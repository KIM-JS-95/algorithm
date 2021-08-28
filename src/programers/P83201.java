// 프로그래머스 위클리 챌린지 2주차
// https://programmers.co.kr/learn/courses/30/lessons/83201

// i==j 배열의 값의 최대 최소 확인하기


package programers;

public class P83201 {
    public static void main(String[] args) {

        int[][] scores = {
                {100,90,98,88,65},
                {50,45,99,85,77},
                {47,88,95,80,67},
                {61,57,100,80,65},
                {24,90,94,75,65}
        };
        System.out.println(solution(scores));
    }

    public static String solution(int[][] scores) {
        String answer = " ";

        for(int i=0; i<scores.length; i++){
            int self = scores[i][i];
            boolean flag = true;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int total = 0;
            int cnt = scores.length;

            for(int j=0; j< scores.length; j++){
                int score = scores[j][i];

                // i==j 배열의 값 외에 다른 배열에 동일한 값이 존재하는 경우
                if(i != j && self == score){
                    flag = false;
                }

                min = Math.min(min, score);
                max = Math.max(max, score);

                total += score;
            }

            // 자기자신의 값이며 그 값이 최소 혹은 최대 일경우
            // 자신의 값을 제외한 나머지의 평균을 구할것
        if(flag && (min ==self || max == self)){
            cnt--;
            total -= self;
        }

        answer += calulateRank((double)total/ (double)cnt);
        }

        return answer;
    }

    public static String calulateRank(double score){
        if(score >= 90.0)
            return "A";
        else if(score >= 80.0)
            return "B";
        else if(score >= 70.0)
            return "C";
        else if(score >= 50.0)
            return "D";
        else
            return "F";
    }
}
