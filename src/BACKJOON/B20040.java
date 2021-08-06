package BACKJOON;


import java.util.Scanner;

public class B20040 {
    public static int v, e, res;
    public static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        parent= new int[v];
        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 사이클이 형성되는지 확인
            if(!union(a, b)) {
                res = i;
                break;
            }
        }

        System.out.println(res);


    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a==b) return false;
        parent[b] = a;
        return true;
    }

    public static int find(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
