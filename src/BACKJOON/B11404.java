package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B11404 {
    public static int n;
    public static int[][] fares;
    public static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());

        fares = new int[n+1][x+1];

        for(int i=1; i <= n; i++) {
            for(int j=1; j <= n; j++) {
                if(i == j) continue;
                fares[i][j] = INF;
            }
        }

        while(x-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int fare = Integer.parseInt(st.nextToken());

            fares[start][end] = Math.min(fares[start][end], fare);
        }

        floyd();
        print();
    }

    public static void floyd(){
        for(int k = 1; k <= n; k++) {
            for(int i=1; i <= n; i++) {
                for(int j=1; j <= n; j++) {
                    fares[i][j] = Math.min(fares[i][k] + fares[k][j], fares[i][j]);
                }
            }
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (fares[i][j] >= INF) sb.append("0 ");
                else sb.append(fares[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
