// 1. expression 쪼개서 oper, number 구분할 것
// 2. 우선순위 배열 정의
// 3.  계산

package KAKAO;

import java.util.*;

public class 수식최대화 {

    public static long answer = Long.MIN_VALUE;
    public static ArrayList<Long> numlist = new ArrayList<>();
    public static ArrayList<String> operlist = new ArrayList<>();

    public static String[] oper = {"*", "-", "+"};

    // oper 우선순위 저장
    public static String[] output = new String[3];
    public static boolean[] visit = new boolean[3];

    public static void main(String[] args) {

        String r1 = "100-200*300-500+20";

        System.out.println(solution(r1));
    }

    public static long solution(String expression) {
        String n = "";

        // 1.
        for (int i = 0; i < expression.length(); i++) {
            char exp = expression.charAt(i);
            if (exp == '*' || exp == '-' || exp == '+') {
                operlist.add(exp + "");
                numlist.add(Long.parseLong(n));

                // 채워준 만큼 초기화 해주어야 함
                n = "";
            } else {
                n += exp;
            }
        }
        numlist.add(Long.parseLong(n));

        // 2. dfs 방식??
        dfs(0, oper.length);

        return answer;
    }

    public static void dfs(int node, int r) {

        if (node == r) {
            solve();

            return;
        }

        // 연산자 모든 경우 위치
        for (int i = 0; i < oper.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                // 우선순위로 output에 넣기
                output[node] = oper[i];
                dfs(node + 1, r);
                visit[i] = false;
            }
        }
    }

    //3. 계산

    static void solve() {
        // 연산자 우선 순위에 따른 값을 얻기 위해 List 복사
        ArrayList<String> oper = new ArrayList<String>();
        oper.addAll(operlist);

        ArrayList<Long> num = new ArrayList<Long>();
        num.addAll(numlist);

        for (int i = 0; i < output.length; i++) {
            String curOper = output[i]; // 현재 우선순위 연산자

            for (int j = 0; j < oper.size(); j++) {

                if (oper.get(j).equals(curOper)) { // 현재 우선순위에 맞는 연산자일 경우
                    long n1 = num.get(j);
                    long n2 = num.get(j + 1);
                    long res = cal(n1, n2, curOper);

                    // 뒤에서부터 삭제해 주어야함 배열 초과 발생
                    num.remove(j + 1); // 숫자 삭제
                    num.remove(j);
                    oper.remove(j); // 연산자 삭제


                    num.add(j, res); // 연산 결과 넣기

                    j--; // 삭제했으니 인덱스 하나 줄여주기
                }
            }
        }

        answer = Math.max(answer, Math.abs(num.get(0)));
    }

    static long cal(long n1, long n2, String o) {
        long ans = 0;

        switch (o) {
            case "+":
                ans = n1 + n2;
                break;

            case "-":
                ans = n1 - n2;
                break;

            case "*":
                ans = n1 * n2;
                break;
        }
        return ans;
    }

}
