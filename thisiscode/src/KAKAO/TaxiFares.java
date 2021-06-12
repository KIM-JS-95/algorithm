package KAKAO;

public class TaxiFares {
    public static final int INF = 1000000000;
    public static int[][] dist= new int[200][200];

    public static void main(String[] args) {
        int n = 6; // node
        int s = 4; // start point
        int a = 6; // A end
        int b = 2; // B end

        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66},{2, 3, 22}, {1, 6, 25}};

        solution(n,s,a,b,fares);

    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if (i == j) {
                    dist[i][j] = 0;
                }else {
                    dist[i][j] =INF;
                }
            }
        }

        for(int[] edge : fares){
            dist[edge[0]-1] [edge[1]-1] = edge[2];
            dist[edge[1]-1] [edge[0]-1] = edge[2];
        }

        floyd(n);

        --s;
        --a;
        --b;

        int answer = INF;

        for(int k=0; k<n; k++){
            answer = Math.min(dist[s][k] + dist[k][a] + dist[k][b], answer);
        }

        System.out.println(answer);
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
