package ThisCoTe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node44 implements Comparable<Node44> {
    int distacne;
    int a;
    int b;

    public Node44(int distacne, int a, int b) {
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

class Position implements Comparable<Position> {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // X축, Y축 순서대로 정렬
    @Override
    public int compareTo(Position other) {
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }

}

public class Q44 {
    static ArrayList<Node44> edges = new ArrayList<>();
    static int[] parent = new int[20001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        ArrayList<Position> x = new ArrayList<Position>();
        ArrayList<Position> y = new ArrayList<Position>();
        ArrayList<Position> z = new ArrayList<Position>();

        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            x.add(new Position(a, i));
            y.add(new Position(b, i));
            z.add(new Position(c, i));
        }

        Collections.sort(x);
        Collections.sort(y);
        Collections.sort(z);


        for (int i = 0; i < n - 1; i++) {
            edges.add(new Node44(x.get(i + 1).getX() - x.get(i).getX(), x.get(i).getY(), x.get(i + 1).getY()));
            edges.add(new Node44(y.get(i + 1).getX() - y.get(i).getX(), y.get(i).getY(), y.get(i + 1).getY()));
            edges.add(new Node44(z.get(i + 1).getX() - z.get(i).getX(), z.get(i).getY(), z.get(i + 1).getY()));
        }


        Collections.sort(edges);

        int result=0;
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistacne();
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (find(a) != find(b)) {
                union(a, b);
                result += cost;
            }
        }
        System.out.println(result);
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

