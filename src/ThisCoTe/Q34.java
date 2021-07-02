package ThisCoTe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q34 {
    static int[] dp =new int[20];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr =new ArrayList<>();
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }

        Collections.reverse(arr);


        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }


        for(int i=1; i<n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) < arr.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(n - maxValue);
    }
}
