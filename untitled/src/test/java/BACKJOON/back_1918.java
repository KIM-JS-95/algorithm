package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class back_1918 {

    public static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();


        solution(c);

    }

    public static void solution(char[] st) {
        StringBuilder sb =new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char arr = 0;
        for (int i = 0; i < st.length; i++) {
            arr = st[i];

            if (arr >= 'A' && arr <= 'Z') {
                sb.append(arr);
            } else if (arr == '(') {
                stack.push(arr);
            }else if(arr == ')'){
                while(stack.size()>0 && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else{
                if(arr== '*' || arr=='/'){
                    while (stack.size() > 0 && (stack.peek() == '*' || stack.peek() == '/' )){
                        sb.append(stack.pop());
                    }
                }else if(arr == '+' || arr == '-'){
                    while (stack.size() > 0 &&(stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/')){
                        sb.append(stack.pop());
                    }
                }
                stack.push(arr);
            }

        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb.toString());
    }

//    public static void solution(String st) {
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < st.length(); i++) {
//            char arr = st.charAt(i);
//
//            if (arr >= 'A' && arr <= 'Z') {
//                answer += arr;
//            } else if (arr == '(') {
//                stack.push(arr);
//            }else if(arr == ')'){
//                while(stack.size()>0 && stack.peek() != '('){
//                    answer += stack.pop();
//                }
//                stack.pop();
//            }else{
//                if(arr== '*' || arr=='/'){
//                    while (stack.size() > 0 && (stack.peek() == '*' || stack.peek() == '/' )){
//                        answer +=stack.pop();
//                    }
//                }else if(arr == '+' || arr == '-'){
//                    while (stack.size() > 0 &&(stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/')){
//                        answer +=stack.pop();
//                    }
//                }
//                stack.push(arr);
//            }
//
//        }
//        while (!stack.isEmpty()) {
//            answer += stack.pop();
//        }
//
//        System.out.print(answer);
//    }

}
