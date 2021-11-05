package BACKJOON;

import java.util.Scanner;
import java.util.Stack;

public class B17298 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        stack.push(0);
        // 첫번째 인덱스 저장
        for (int i = 1; i < n; i++) {

            if (stack.isEmpty()) {
                stack.push(i);
                // 반복문에 들어올 때 스택이 비어있으면 인덱스 저장
            }

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {

                a[stack.pop()] = arr[i];
            }

            stack.add(i);
        }

        while (!stack.isEmpty()) {
            // 반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌 때 까지
            a[stack.pop()] = -1;
            // stack에 쌓인 index에 -1을 넣고
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(a[i] + " ");
            // 출력한다
        }
        System.out.println(sb);

    }
}

