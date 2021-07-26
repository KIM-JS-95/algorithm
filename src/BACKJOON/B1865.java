package BACKJOON;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


class Road{
    // 출발노드
    int start;
    // 도착노드
    int end;
    // 걸리는 시간
    int cost;

    public Road(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

public class B1865 {
    static final int INF = 1000000000;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, w;
    static Road[] roads;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < testCnt; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //3
            m = Integer.parseInt(st.nextToken()); //3
            w = Integer.parseInt(st.nextToken()); //1

            dist = new int[n + 1];
            roads = new Road[2 * m + w];

            // roads[]의 인덱스를 나타낸다.
            int index = 0;

            for(int j = 0 ; j < m + w; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                // 무방향이기 때문에 반대방향도 추가한다.
                if(j < m){
                    roads[index++] = new Road(start, end, cost);
                    roads[index++] = new Road(end, start, cost);
                    // 웜홀은 유방향이기 때문에 시간만 * -1 해주어서 추가한다.
                }else{
                    roads[index++] = new Road(start, end, cost * -1);
                }
            }

            // 음수 사이클이 있는 경우
            if(bellmanFord())
                sb.append("YES\n");
                // 음수 사이클이 없는 경우
            else
                sb.append("NO\n");

            for(int val : dist){
                System.out.print(val + " ");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();

    }

    private static boolean bellmanFord(){
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i < n; i++) {
            // edge개수 만큼 확인을 한다.
            for (int j = 0; j < roads.length; j++) {
                Road road = roads[j];

                if (dist[road.start] != INF && dist[road.start] + road.cost < dist[road.end]){
                    dist[road.end] = dist[road.start] + road.cost;
                }
            }
        }
        for(int i = 0 ; i < roads.length; i++){
            Road road = roads[i];

            if (dist[road.start] != INF && dist[road.start] + road.cost < dist[road.end])
                return true;
        }
        return false;
    }
}
