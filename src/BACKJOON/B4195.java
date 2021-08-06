package BACKJOON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class B4195 {
    static int[] parent, count;
    private static int T;
    private static int F;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            F = sc.nextInt();
            parent = new int[F * 2];
            count = new int[F * 2];
            for (int i = 1; i < F*2; i++) {
                parent[i] = i;
            }

            Arrays.fill(count, 1); //최초 친구 수는 기본값으로 한명이다
            HashMap<String, Integer> map = new HashMap<>(); // 이름, 인덱스(노드번호)
            int index = 0;
            for (int f = 0; f < F; f++) {
                String friend1 = sc.next();
                String friend2 = sc.next();
                if (!map.containsKey(friend1)) { //해당 친구이름이 아직 없는 경우 인덱스 부여
                    map.put(friend1, index++);
                }
                if (!map.containsKey(friend2)) {
                    map.put(friend2, index++);
                }
                System.out.println(union(map.get(friend1), map.get(friend2)));
            }
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) {
                parent[y] = x;
                count[x] += count[y];
                return count[x];
            } else {
                parent[x] = y;
                count[y] += count[x];
                return count[y];
            }
        }
        return count[x];
    }
}
