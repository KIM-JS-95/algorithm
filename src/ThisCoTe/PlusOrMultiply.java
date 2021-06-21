package ThisCoTe;

import java.util.Arrays;
import java.util.Scanner;

public class PlusOrMultiply {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int[] arr = new int[str.length()];

        Arrays.sort(arr);

        int ans = 0;
        int cnt=0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i) - '0';
            if (ans == 0) {
                ans += arr[i];
            } else {
                ans *= arr[i];
            }
            cnt++;

            temp = Math.max(temp, ans);
        }

        for (int i = 1; i < arr.length; i++) {
            // 두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
            int num = str.charAt(i) - '0';
            if (num <= 1 || ans <= 1) {
                ans += num;
            }
            else {
                ans *= num;
            }
        }

        System.out.println(temp);
        time();
    }

    public static void time() {
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        System.out.println("시간차이(ms) : "+(end-start)/1000.0);

    }
}
