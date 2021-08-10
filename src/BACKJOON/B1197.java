package BACKJOON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Ko implements Comparable<Ko> {

    public int distance;
    private int nodeA;
    private int nodeB;

    public Ko(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

    @Override
    public int compareTo(Ko o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}

public class B1197 {
    static int[] parent;
    static int v, e;
    static int result = 0;
    static ArrayList<Ko> list = new ArrayList<>();

    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();
        parent=new int[v+1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            list.add(new Ko(cost, a, b));
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int cost = list.get(i).getDistance();
            int a =list.get(i).getNodeA();
            int b = list.get(i).getNodeB();
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }
        System.out.println(result);
    }
}
