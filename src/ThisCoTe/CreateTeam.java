// 7 8
// 0 1 3
// 1 1 7
// 0 7 6
// 1 7 1
// 0 3 7
// 0 4 2
// 0 1 1
// 1 1 1

package ThisCoTe;

import java.util.Scanner;

public class CreateTeam {

    public static int e, v;
    private static int[] parent = new int[10001];

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        e = sc.nextInt();
        v = sc.nextInt();

        for (int i = 1; i < e; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < v; i++) {
            int oper = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (oper == 0) {
                union(a, b);
            } else if (oper == 1) {
                if (find(a) == find(b)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}