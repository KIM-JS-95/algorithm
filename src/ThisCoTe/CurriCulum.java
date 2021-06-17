// 5
// 10 -1
//10 1 -1
//4 1 -1
//4 3 1 -1
// 3 3 -1


package ThisCoTe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CurriCulum {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static int[] times = new int[1001];
    public static int[] indegree = new int[1001];
    public static int v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 소모 시간
        for (int i = 1; i <= v; i++) {
            int x = sc.nextInt();
            times[i] = x;

            // 노드 경로 입력 (a에서 i 방향으로 수강할 것)
            while (true) {
                int a = sc.nextInt();
                if (a == -1) break;
                indegree[i] +=1;
                graph.get(a).add(i);
            }
        }

        topology();

    }

    public static void topology(){
        Queue<Integer> q = new LinkedList<Integer>();
        int[] result = new int[1001];

        for(int i=1; i<=v; i++){
            result[i] = times[i];
        }

        // 접근 간선이 없는 노드 부터 시작
        for(int i=1; i<=v; i++) {
            if (indegree[i] == 0) {
            q.add(i);
            }
        }

        while(true){
            int now = q.poll();
            for(int i=1; i<=graph.get(now).size(); i++){
                result[graph.get(now).get(i)]=Math.max(graph.get(now).get(i), times[graph.get(now).get(i)] + result[now]);

                indegree[graph.get(now).get(i)] -= 1;
                // 접근 간선이 없다면
                if(indegree[graph.get(now).get(i)] ==0){
                    q.offer(indegree[graph.get(now).get(i)]);
                }
            }
        }
    }
}
