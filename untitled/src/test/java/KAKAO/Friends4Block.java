package KAKAO;

public class Friends4Block {

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        solution(m, n, board);

    }

    public static int solution(int m, int n, String[] board) {

        char[][] map = new char[n][m];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                map[j][i] = board[i].charAt(j);
            }
        }

        int answer = 0;
        boolean flag = true;

        while (flag) {

            flag = false;
            int[][] visited = new int[n][m];

            for (int i = 0; i < map.length - 1; i++) {
                for (int j = 0; j < map[i].length - 1; j++) {

                    if (map[i][j] == '0') continue;

                    if (map[i][j] == map[i + 1][j] && map[i + 1][j] == map[i + 1][j + 1]
                            && map[i][j + 1] == map[i + 1][j + 1] && map[i][j + 1] == map[i][j]) {
                        visited[i][j] = 1;
                        visited[i][j + 1] = 1;
                        visited[i + 1][j] = 1;
                        visited[i + 1][j + 1] = 1;

                        flag = true;
                    }
                }
            }


            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j< visited[i].length; j++) {

                    if (visited[i][j] == 1) {

                        answer++;

                        for (int k = j-1; k >= 0; k--) {

                            map[i][k+1] = map[i][k];
                            map[i][k] = '0';
                        }
                    }
                }
            }

        }

        return answer;
    }
}
