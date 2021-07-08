package ThisCoTe;

import java.util.Scanner;

public class Q42 {

    public static int[] pa = new int[500];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            pa[i] = i;
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int root = findpa(x);
            if (root == 0) break;

            union(root, root - 1);
            result++;
        }
        System.out.println(result);
    }

    static int findpa(int x) {
        if (x == pa[x]) return x;

        return pa[x] = findpa(pa[x]);
    }

    static void union(int a, int b) {
        a = findpa(a);
        b = findpa(b);

        if (a < b) pa[b] = a;
        else pa[a] = b;
    }
}
