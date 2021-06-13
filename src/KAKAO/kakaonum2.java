package KAKAO;


import java.util.Queue;

public class kakaonum2 {

    public static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        String[] places = {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"};
//                ,"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"
//                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
//                {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
//                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
//                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        solution(places);

    }

    static Queue<Node> q;
    static Queue<Node> waterQ;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static boolean[][] visited;
    static Node[] swan;
    static int R, C;
    static char[][] maplist;
    public static int solution(String[] places) {
        int answer = 1;
        map = new char[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places.length; j++) {
                map[i][j] = places[i].charAt(j);
            }
        }

        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places.length; j++) {
                maplist[i][j] = places[i].charAt(j);
            }
        }

        for (int i = 1; i < places.length; i++) {
            for (int j = 1; j < places.length; j++) {
                if(map[i-1][j-1]=='P' && map[i-1][j]=='X' && map[i][j-1]=='O' && map[i][j]=='P'){
                    answer=0;
                    break;
                }else if(map[i-1][j-1]=='P' && map[i-1][j]=='O' && map[i][j-1]=='O' && map[i][j]=='X'){
                    answer=0;
                    break;
                }else if(map[i-1][j-1]=='X' && map[i-1][j]=='X' && map[i][j-1]=='X' && map[i][j]=='X'){
                    answer=0;
                    break;
                }else if(map[i-1][j-1]=='P' && map[i-1][j]=='O' && map[i][j-1]=='X' && map[i][j]=='P'){
                    answer=0;
                    break;
                }else if(map[i-1][j-1]=='P' && map[i-1][j]=='P' && map[i][j-1]=='P' && map[i][j]=='P'){
                    answer=0;
                    break;
                }else if(map[i-1][j-1]=='P' && map[i-1][j]=='P' && map[i][j-1]=='X' && map[i][j]=='X'){
                    answer=0;
                    break;
                }else if(map[i-1][j-1]=='P' && map[i-1][j]=='O' && map[i][j-1]=='X' && map[i][j]=='P'){
                    answer=0;
                    break;
                }
                else{
                    answer=1;
                }
            }
        }

        System.out.println(answer);
        return answer;
    }

}