package BACKJOON;


import java.util.Scanner;

public class B7568 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++) {
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j]=sc.nextInt();
            }
        }

        solution(n,arr);
    }
    static void solution(int n, int[][] arr){
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    cnt[i]++;
                }
            }
            System.out.print((cnt[i]+1)+ " ");
        }

    }
}
