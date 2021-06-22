package ThisCoTe;

import java.util.Scanner;

public class LuckyStraight {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int ans1 = 0;
        int ans2 = 0;

        int[] arr1 = new int[str.length() / 2];
        int[] arr2 = new int[str.length() / 2];

        for (int i = 0; i < str.length() / 2; i++) {
            arr1[i] = str.charAt(i) - '0';
            arr2[i] = str.charAt(i + str.length() / 2) - '0';
        }

        if (str.length() % 2 != 0) {
            System.out.println("READY");
        } else {
            for (int i = 0; i < str.length() / 2; i++) {
                ans1 += arr1[i];
                ans2 += arr2[i];
            }
        }
        if (ans1 == ans2) {
            System.out.println("Lucky");
        } else {
            System.out.println("READY");
        }

    }
}
