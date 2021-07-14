package BACKJOON;


import java.util.*;

class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B2667 {

    static ArrayList<Integer> apt = new ArrayList<>();
    static int[] _x = {-1, 0, 0, 1};
    static int[] _y = {0, 1, -1, 0};
    static int n;
    static boolean[][] visit;

    public static void bfs(char[][] map, int n, int _i, int _j) {
        Queue<Pos> q = new LinkedList<>();
        if(map[_i][_j] == '0' || visit[_i][_j]) return ;

        q.add(new Pos(_i, _j));
        visit[_i][_j] = true;

        int cnt = 1;
        while(!q.isEmpty()) {
            Pos p = q.remove();
            int x = p.x;
            int y = p.y;

            for(int i=0; i<4; i++) {
                int nx = x + _x[i];
                int ny = y + _y[i];

                if( 0<=nx && nx<n && 0<=ny && ny<n ) { // 범위 안으로
                    if( !visit[nx][ny] && map[nx][ny] == '1' ) {
                        visit[nx][ny] = true;
                        q.add(new Pos(nx, ny));
                        cnt++;
                    }
                }
            }
        }
        apt.add(cnt);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        n = sc.nextInt();
        visit = new boolean[n][n];
        char[][] map = new char[n][n];

        sc.nextLine();
        for(int i=0; i<n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                bfs(map, n, i, j);
            }
        }

        System.out.println(apt.size());
        apt.sort(null);
        for(int n : apt) {
            System.out.println(n);
        }

    }

}
