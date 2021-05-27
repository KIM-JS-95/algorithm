package ThisCoTe;

import java.util.Scanner;

public class UpDownLeftRight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] xd = {0, 0, -1, 1};
        int[] yd = {-1, 1, 0, 0};
        char[] type = {'L', 'R', 'U', 'D'};

        int n = sc.nextInt();
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");

        int x = 1;
        int y = 1;

        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);

            int nx = -1;
            int ny = -1;

            for (int j = 0; j < 4; j++) {
                if(plan == type[j]) {
                    nx = x + xd[j];
                    ny = y + yd[j];
                }
            }

        if(nx>n || ny>n || nx<1 || ny<1) continue;

        x=nx;
        y=ny;

        }

        System.out.println(x + " " + y);
    }
}
