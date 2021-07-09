package KAKAO;

import java.util.HashMap;

public class Q2017main {
    static boolean[] visited = new boolean[100];
    static int answer = 0;
    static int[] ch=new int[8];
    static String[] d;
    static HashMap<Character, Integer> map;

    public static void main(String[] args) {
        String[] data = {"N~F=0", "R~T>2"};
        int n = 2;

        solution(n, data);
    }

    public static void solution(int n, String[] data) {
        d = data;
        map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);

        dfs(0);

        System.out.println(answer);
    }

    public static boolean check() {
        int a, b, res;
        char op;
        for (String s : d) {
            a = ch[map.get(s.charAt(0))];
            b = ch[map.get(s.charAt(2))];
            op = s.charAt(3);
            res = s.charAt(4) - '0' + 1;

            if (op == '=') {
                if (Math.abs(a - b) != res) return false;
            } else if (op == '>') {
                if (Math.abs(a - b) <= res) return false;
            } else {
                if (Math.abs(a - b) >= res) return false;
            }
        }
        return true;
    }

    public static void dfs(int idx) {
        if (idx == 8) {
            if (check()) answer++;
        } else {
            for (int i = 0; i < 8; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    ch[idx] = i;
                    dfs(idx + 1);
                    visited[i] = false;
                }
            }
        }
    }

}
