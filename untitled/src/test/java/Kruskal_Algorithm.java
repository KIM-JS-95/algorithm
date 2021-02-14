import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kruskal_Algorithm {

    static int V, E, parents[];
    static Edge[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 3
        E = Integer.parseInt(st.nextToken()); // 3

        edgeList = new Edge[E];
        parents = new int[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(a, b, c);
        }
        System.out.println(kruskal());
    }

    private static int kruskal(){
        int res=0;
        int cnt=0;

        Arrays.sort(edgeList);
        make();

        for(Edge edge : edgeList){
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

    private static void make() {
        for(int i=0; i<=V; i++){
            parents[i] =i;
        }
    }


    static class Edge implements Comparable<Edge> {
        int from, to, weight;


        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }

    }
}
