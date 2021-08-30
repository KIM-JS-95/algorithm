// 프로그래머스 2021 카카오 채용
// https://programmers.co.kr/learn/courses/30/lessons/72413
package KAKAO;

import java.util.Arrays;

// 특정 지점에서 특정 지점까지 최단 경로
// 플로이드 워셜 알고리즘 적용
public class 합승택시요금 {

    public static int[][] dist = new int[200][200];
    public static final int INF = 1000000;

    public static void main(String[] args){
    int n=6;
    int s = 4;
    int a=6;
    int b=2;
    int[][] fares={{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

    System.out.print(solution(n,s,a,b,fares));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {

        for(int i=0; i<dist.length; i++){
            Arrays.fill(dist[i], INF);
        }

        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if (i == j) {
                    dist[i][j] = 0;
                }else {
                    dist[i][j] =INF;
                }
            }
        }

        // 배열의 비용을 획득하여 dist 배열에 넣어주어야함
        // 양방향
        for(int[] edge : fares){
            dist[edge[0]-1][edge[1]-1]=edge[2];
            dist[edge[1]-1][edge[0]-1]=edge[2];
        }


        // n= 지점 갯수
        floyd(n);

        --s;
        --a;
        --b;

        int answer = INF;

        for(int k=0; k<n; k++){
            answer = Math.min(dist[s][k] + dist[k][a] + dist[k][b], answer);
        }

        return answer;
    }

    public static void floyd(int n){
        for(int k = 0; k < n; k++) {
            for(int i=0; i < n; i++) {
                for(int j=0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
    }
}
