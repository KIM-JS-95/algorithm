package BACKJOON;

import java.io.IOException;
import java.util.Scanner;

public class back_10451 {

    public static int[] arr;
    public static boolean[] flag;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int  t =sc.nextInt();

        for(int i=0; i<t; i++){
            int cnt =0;
            int N = sc.nextInt();
            arr = new int[N+1];
            flag = new boolean[N+1];

            for(int j=1; j<N+1; j++){
                arr[j]= sc.nextInt();
            }
            for(int j=1; j<N+1; j++){
                if(!flag[j])
                cnt +=solution(j);
            }
            System.out.println(cnt);
        }
    }

    public static int solution(int i){

        if(i==arr[i] || flag[i])
            return 1;

        flag[i] = true;
        return solution(arr[i]);

    }
}
