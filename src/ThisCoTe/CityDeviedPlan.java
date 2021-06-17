//7 12
//1 2 3
//1 3 2
//3 2 1
//2 5 2
//3 4 4
//7 3 6
//5 1 5
//1 6 2
//6 4 1
//6 5 3
//4 5 3
//6 7 4


package ThisCoTe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    private int nodeA;
    private int nodeB;
    private int distance;

    public Edge(int a, int b, int distance) {
        this.nodeA = a;
        this.nodeB = b;
        this.distance = distance;
    }
    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int getDistance() {
        return distance;
    }

    // 거리 비용이 짧은 것이 우선 순위 높게
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class CityDeviedPlan {

    public static int result, remove;
    public static int[] parent = new int[1001];
    public static ArrayList<Edge> edge1 = new ArrayList<Edge>();

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i=1; i<=N;i++){
            parent[i]=i;
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(); // node a
            int b = sc.nextInt(); // node b
            int c = sc.nextInt(); // distance
            // 원소 초기화
            edge1.add(new Edge(a,b,c));
        }
        Collections.sort(edge1); // 크루스칼 필수 오름차순 정렬

        for(int i = 0; i< edge1.size(); i++){
            int dis = edge1.get(i).getDistance();
            int a = edge1.get(i).getNodeA();
            int b = edge1.get(i).getNodeB();
            // No Cycle
            if(find(a) != find(b)){
                union(a,b);
                result += dis;
                remove = dis;
            }
        }
        System.out.print(result);
    }
}
