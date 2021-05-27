package ThisCoTe;

import java.util.Scanner;

public class Time {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();

        int cnt = 0;

        for (int i = 0; i <= h; i++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    if (check(i, m, s))
                        cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static boolean check(int h, int m, int s) {
        if(h%10==3 || m%10==3 || m/10==3 || s%10==3 || s/10==3)
            return true;

        return false;
    }

}
