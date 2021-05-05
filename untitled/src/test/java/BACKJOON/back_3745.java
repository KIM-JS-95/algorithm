package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class back_3745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> list = new LinkedList<>();
        int cnt = sc.nextInt();
        int[] array = new int[cnt + 1];
        int[] dp = new int[cnt + 1];

            for (int j = 0; j < cnt; j++) {
                array[j] = sc.nextInt();
            }
            //dp[0] = array[0];

            for (int i = 0; i < cnt; i++) {
                dp[i] = array[i];
                for (int k = 0; k < cnt; k++) {
                    if (array[i] > array[k] && !list.contains(dp[k])) {
                        list.add(dp[k]);
                        System.out.println(dp[k]);
                    }
                    //max = max < dp[i] ? dp[i] : max;
                }
            }
            while(!list.isEmpty()) {
                System.out.print(list.poll() + " ");
            }

        }
    }
