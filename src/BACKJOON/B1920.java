package BACKJOON;

import java.util.Arrays;
import java.util.Scanner;


public class B1920 {
    public static int[] arr1;
    public static int[] arr2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        Arrays.sort(arr1);

        int m = sc.nextInt();
        arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int t = arr2[i];
            boolean re = binary(0, n-1 , t);
            if (re) {
                System.out.println("1");
            }
            if (!re) {
                System.out.println("0");
            }


        }
    }

    static boolean binary(int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr1[mid] == target) {
                return true;
            } else if (arr1[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
