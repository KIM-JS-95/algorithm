package BACKJOON;

import java.io.*;
import java.util.*;


class Node10 implements Comparable<Node10> {
    int end;
    int distanse1;

    public Node10(int end, int distanse) {
        this.end = end;
        this.distanse1 = distanse;
    }

    @Override
    public int compareTo(Node10 o) {
        if (this.distanse1 < o.distanse1) {
            return -1;
        } else {
            return 1;
        }
    }

    public int getEnd() {
        return end;
    }


    public void setDistanse1(int distanse1) {
        this.distanse1 = distanse1;
    }

    public int getDistanse1() {
        return distanse1;
    }
}

public class B9370 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 10_000_000;
    static int vertex, edge, t;
    static int start, g, h;
    static int arr[][];
    static int dist[];
    static boolean check[];
    static List<Integer> answerList;
    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCnt; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            arr = new int[vertex + 1][vertex + 1];
            dist = new int[vertex + 1];
            for(int j = 0 ; j < arr.length; j++)
                Arrays.fill(arr[j], INF);
            Arrays.fill(dist, INF);
            check = new boolean[vertex + 1];


            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());


            for(int j = 0 ; j < edge; j++){
                st = new StringTokenizer(br.readLine());
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());

                arr[vertex1][vertex2] = arr[vertex2][vertex1] = distance * 2;
            }


            arr[h][g] = arr[g][h] = arr[h][g] - 1;

            answerList = new ArrayList<>();

            for(int j = 0; j < t; j++)
                answerList.add(Integer.parseInt(br.readLine()));

            dijkstra();

            Collections.sort(answerList);

            for(int num : answerList)
                if(dist[num] % 2 == 1) bw.write(num + " ");
            bw.write("\n");
        }

        bw.close();
        br.close();
    }

    private static void dijkstra(){
        PriorityQueue<Node10> queue = new PriorityQueue<>();
        queue.add(new Node10(start, 0));
        dist[start] = 0;

        // 큐가 빌 때까지
        while(!queue.isEmpty()){
            Node10 curNode10 = queue.poll();
            int cur = curNode10.end;
            // 이미 방문한 노드인 경우 패스
            if(check[cur]) continue;
            // 방문 처리
            check[cur] = true;

            for(int i = 1; i <= vertex; i++){
                if(check[i] == false && dist[i] > dist[cur] + arr[cur][i]){
                    dist[i] = dist[cur] + arr[cur][i];
                    queue.add(new Node10(i, dist[i]));
                }
            }
        }
    }
}
