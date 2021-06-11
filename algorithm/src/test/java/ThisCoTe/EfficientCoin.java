package ThisCoTe;

// Construct a given currency and obtain a minimum number of coins to make the target currency.

// ex)  total = 7
//      coin = {2,3,7}
//      return = 2

import java.util.Arrays;
import java.util.Scanner;

public class EfficientCoin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of coins
        int m = sc.nextInt(); // target

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] d = new int[m + 1];
        Arrays.fill(d, 1001);

        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                if (d[j - arr[i]] != 1001)
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1);
            }
        }

        if (d[m] == 1001) {
            System.out.print(-1);
        } else {
            System.out.print(d[m]);

        }
    }
}
