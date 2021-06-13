package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_1922 {

    public static class edge implements Comparable<edge> {
        int from, to, weight;

        public edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static int V, E, parents[];
    public static edge[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        edgeList = new edge[E];
        parents = new int[V + 1];

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList[i] = new edge(a, b, c);
        }
        System.out.println(kruskal());
    }

    public static int kruskal(){
        int res = 0;
        int cnt =0;

        Arrays.sort(edgeList);
        make();

        for(edge edge : edgeList){
            if(union(edge.from, edge.to)){
                res += edge.weight;

                if(++cnt == V-1) return res;
            }
        }
        return res;
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        parents[aRoot] = bRoot;
        return true;
    }

    private static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    public static void make(){
        for(int i=0; i<=V; i++){
            parents[i] =i;
        }

    }

}

