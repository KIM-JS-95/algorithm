package ThisCoTe;

import java.util.Scanner;

public class Translating_parentheses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(solution(s));

    }

    private static String solution(String w) {
        String answer = "";
        if (w.equals(answer)) return answer;

        int index = indexcheck(w);
        String u = w.substring(0, index + 1);
        String v = w.substring(index + 1);

        // 올바른 문자열이야?
        if(check(u)){
            answer = u+solution(v);
        }
        //올바른 문자열이 아니야?
        else{
            answer +='(';
            answer += solution(v);
            answer += ')';

            u = u.substring(1,u.length()-1);
            String temp="";
            for(int i=0; i<u.length(); i++){
                if(answer.charAt(i)=='(') temp +=")";
                else temp +="(";
            }
            answer += temp;
        }
        return answer;
    }

    private static int indexcheck(String w) {
        int cnt=0;
        for(int i=0; i<w.length();i++){
            if(w.charAt(i)=='(') cnt++;
            else cnt--;
            if(cnt==0) return i; // 짝이 맞는다.
        }
        return -1;
    }

    private static boolean check(String w) {
        int cnt = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') cnt++;
            else{
                if (cnt == 0)
                    return false;
            }
            cnt--;
        }
        return true;
    }
}
