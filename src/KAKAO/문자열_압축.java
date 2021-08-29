// 문자열의 길이 1부터 step 크기만큼 늘려가며 확인
// 문자열 압축
// 문자열 압축 후
package KAKAO;

public class 문자열_압축 {

    public static void main(String[] args) {

        String s = "abcabcabcabcdededededede";

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer  =s.length();
        for(int step =1; step<s.length()/2+1; step++){
            String com = "";
            String prev = s.substring(0, step);

            int cnt = 1;

            for(int j=step; j<s.length(); j+=step){
                String sub = "";
                for(int k=j; k<j + step; k++){
                    if(k<s.length())
                        sub += s.charAt(k);
                }
                if(prev.equals(sub)) cnt++;

                else{
                    com +=(cnt>=2) ? cnt + prev : prev;
                    sub = "";

                    for (int k = j; k < j + step; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub; // 다시 상태 초기화
                    cnt = 1;
                }
            }

            com += (cnt >= 2)? cnt + prev : prev;

            answer = Math.min(answer, com.length());
        }
        return answer;
    }
}
