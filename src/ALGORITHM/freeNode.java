package ALGORITHM;

import java.util.Scanner;

public class freeNode {
    public static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //binary(arr[0], arr[3], m);

        int start = 0;
        int end = (int)1e9;

        int result = 0;

        while (start <= end) { ;
            int mid = (start + end) / 2;
            long total = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) total += arr[i] - mid;
            }
            if (total < m) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.print(result);
    }

    //public static void binary(int start, int end, int target){
//    int result = 0;
//    int total = 0;
//
//    int mid = (start + end) / 2;
//
//        while(start <=end)
//
//    {
//        for (int i = 0; i < n; i++) {
//            if (arr[i] > mid) total += arr[i] - mid;
//        }
//        if (total < target) {
//            end = mid - 1;
//        } else {
//            result = mid;
//            start = mid + 1;
//        }
//    }
//        System.out.print(result);
//}

}
