package ThisCoTe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class No implements Comparable<Node44> {
    int distacne;
    int a;
    int b;

    public No(int distacne, int a, int b) {
        this.distacne = distacne;
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Node44 o) {
        if (this.distacne < o.distacne)
            return -1;
        else {
            return 1;
        }
    }

    public int getDistacne() {
        return distacne;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

public class Q43 {
    static ArrayList<Node44> edges = new ArrayList<>();
    static int[] parent = new int[20001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            edges.add(new Node44(z,x, y));
        }

        Collections.sort(edges);
        int result=0;
        int total = 0;
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistacne();
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            total += cost;

            if(find(a) != find(b)){
                union(a,b);
                result += cost;
            }
        }

        System.out.println(total-result);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
