package KAKAO;

import java.util.*;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class distanceCheck {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};


    public static void main(String[] args) {

        String[][] map =
                {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
                };

        for(int val : solution(map))
        System.out.print(val + " ");
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = check(places[i]);
        }

        return answer;
    }

    public static int check(String[] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length(); j++) {
                if (map[i].charAt(j) == 'P') {

                    // 거리두기 실패
                    if (!bfs(i, j, map)) return 0;
                }
            }
        }
        return 1;
    }

    public static boolean bfs(int x, int y, String[] map) {
        boolean[][] flag = new boolean[map.length][map.length];
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(x, y));
        flag[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();


            for (int i = 0; i < 4; i++) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];

                // manhatan : Distance of person to person
                int manhatan = Math.abs(x - nx) + Math.abs(y - ny);

                // define Range
                if (nx >= map.length || ny >= map.length || nx < 0 || ny < 0) continue;
                // 방문 했거나 거리가 2 이상이면 안전
                if (flag[nx][ny] == true || manhatan > 2) continue;


                // 방문 x and manhatan 2 이하이면 파티션 존재 여부 확인
                flag[nx][ny] = true;

                // 파티션
                if (map[nx].charAt(ny) == 'X') continue;
                    // 사람
                else if (map[nx].charAt(ny) == 'P') return false;
                else q.offer(new Node(nx, ny));
            }

        }
        return true;
    }

}

