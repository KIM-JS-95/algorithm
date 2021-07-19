package BACKJOON;

import java.util.Scanner;

public class B1011 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            System.out.println(countWarp(x, y));
        }

    }

    public static int countWarp(double x, double y) {
        double distance = y - x;
        double max = Math.round(Math.sqrt(distance));

        if (distance > Math.pow(max, 2)) {
            return (int)max * 2;
        } else {
            return (int)max * 2 - 1;
        }
    }

}
