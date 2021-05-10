package QUESTION;

import java.util.TreeSet;

public class N_Express {
    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        System.out.println(solution(N, number));

    }

    public static int _N;
    public static TreeSet<Integer>[] dynamic;
    public static int solution(int N, int number) {
        _N = N;
        dynamic = new TreeSet[10];
        for (int i = 1; i <= 8; i++) {
            solve(i);

            if (dynamic[i].contains(number)) return i;
        }

        return -1;
    }

    public static TreeSet<Integer> solve(int n) {
        if ((dynamic[n] != null) && !dynamic[n].isEmpty())
            return dynamic[n];

        int num = 0;

        for (int i = 0; i < n; i++)
            num = 10 * num + _N;

        TreeSet<Integer> temp = new TreeSet<>();
        temp.add(num);

        for (int i = 1; i < n; i++) {
            int j = n - i;
            TreeSet<Integer> from = solve(i);
            TreeSet<Integer> to = solve(j);
            for (int n1 : from) {
                for (int n2 : to) {//d[n] = d[n-1] + d[i];
                    temp.add(n1 + n2);
                    temp.add(n1 - n2);
                    temp.add(n1 * n2);
                    if (n2 != 0) temp.add(n1 / n2);
                }
            }
        }

        return dynamic[n] = temp;
    }
}
