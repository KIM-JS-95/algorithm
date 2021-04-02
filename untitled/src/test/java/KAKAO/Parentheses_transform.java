package KAKAO;

import java.util.Stack;

public class Parentheses_transform {

    public static void main(String[] args) {

        String q = ")(";
        solution(q);
    }

    private static int pos = 0;
    private static String solution(String q) {
        if (q.isEmpty()) return q;

        boolean correct = isCorrect(q);

        String u = q.substring(0, pos);
        String v = q.substring(pos, q.length());

        if(correct){
            return u+solution(v);
        }

        String answer = "(" + solution(v) + ")";

        for(int i=1; i<u.length()-1; i++){
            if(u.charAt(i)=='(')
                answer += ")";
            else
                answer +="(";
        }
        return answer;
    }

    public static boolean isCorrect(String str) {
        boolean ret = true;

        int left = 0;
        int right = 0;

        Stack<Character> mystack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left++;
                mystack.push('(');
            } else {
                right++;
                if (mystack.empty())
                    ret = false;
                else {
                    mystack.pop();
                }
            }
            if (left == right) {
                pos = i + 1;
                return ret;
            }
        }
        return true;
    }
}

