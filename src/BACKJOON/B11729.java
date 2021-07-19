package BACKJOON;

import java.util.Scanner;

public class B11729 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        System.out.println(N);

        Hanoi(N, 1, 2, 3);

    }

        public static void Hanoi(int N, int start, int mid, int to)  {
            if (N == 1) {
                System.out.println(start + " " + to);
                return;
            }

            Hanoi(N - 1, start, to, mid);

            System.out.println(start + " " + to);

            Hanoi(N - 1, mid, start, to);

    }
}
