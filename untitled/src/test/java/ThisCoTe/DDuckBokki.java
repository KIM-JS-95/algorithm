package ThisCoTe;

import java.util.Scanner;

public class DDuckBokki {

    public static void main(String[] srgs) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        int start = 0;
        int end = (int) 1e9;

        while (start <= end) {
            int total = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) total += arr[i] - mid;
            }
            if (total < m) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
