package KAKAO;


public class Solution3 {

    public static void main(String[] args) {
        int n=6;
        int[] passenger	 = {1,1,1,1,1,1};
        int[][] train = {{1,2},{1,3},{1,4},{3,5},{3,6}};

        System.out.println(solution(n,passenger,train));


    }

    public static final int INF = 1;
    public static int[][] dist= new int[10][10];
    public static int cnt=0;

    static int answer =0;
    public static int solution(int n, int[] passenger, int[][] train) {


        for(int i=0; i< train.length; i++){
               dist[train[i][0]-1][train[i][1]-1] =1;
        }

        for(int i=0; i< train.length; i++){
            dist[train[i][1]-1][train[i][0]-1] =1;
        }


        for(int i=0; i<train.length; i++){
            int cnt =0;
            while(cnt <=6) {
                if (dist[i][cnt] ==1){
                    i += cnt;
                    answer += dist[i][cnt];

                }
                cnt++;
            }
        }

//        for(int i=0; i< n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dist[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }


        return answer;
    }

    static void DFS(int node, boolean[] visit, int[][] computers){
        visit[node] = true;
        for(int i=0; i<computers.length; i++){
            if(visit[i] == false && computers[node][i]==1){
                DFS(i,visit, computers);
            }
        }
    }

}


