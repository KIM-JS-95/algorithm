package BACKJOON;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B5430 {

    public static StringBuilder sb = new StringBuilder();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        StringTokenizer st;
        ArrayDeque<Integer> deque;

        int n = sc.nextInt();

        // 입력 받기
        while (n -- > 0) {
            String command = sc.next(); // RDD
            int t = sc.nextInt();

            st = new StringTokenizer(sc.next(), "[],"); // [1, 2, 3, 4]

            deque = new ArrayDeque<Integer>();
            // 배열 길이만큼 deque에 넣어주기

            for (int i = 0; i < t; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }


            solution(command, deque);
        }

        // 최종 출력
        System.out.println(sb);
    }

    public static void solution(String command, ArrayDeque<Integer> deque) {

        boolean flag = true;

        for (char cmd : command.toCharArray()) {
            if (cmd == 'R') {

                /*
                !booleanType 는 true to false 혹은 false to true 로 바꿔주기 때문에

                boolean flag =true; 이라면

                (flag=false) != (flag = !flag) 이다.

                  */

                flag = !flag;
                continue;
            }


            if (flag) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        makePrintString(deque,flag);

    }


    public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {

        sb.append('[');	// 여는 대괄호 먼저 StringBuilder에 저장

        if(deque.size() > 0) {	//만약 출력 할 원소가 한 개 이상일 경우

            if(isRight) {	// 정방향일경우

                sb.append(deque.pollFirst());	// 먼저 첫 번째 원소를 넘겨준다.

                // 그 다음 원소부터 반점을 먼저 넘겨준 후 덱의 원소를 하나씩 뽑아 넘긴다.
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else {	// 역방향일경우
                sb.append(deque.pollLast());	// 먼저 뒤에서부터 첫 번째 원소를 넘겨준다.

                // 그 다음 원소부터 반점을 먼저 넘겨준 후 덱의 원소를 뒤에서부터 하나씩 뽑아 넘긴다.
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');	// 닫는 대괄호 및 개행으로 마무리
    }
}

