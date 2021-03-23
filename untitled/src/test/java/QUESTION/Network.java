package QUESTION;

public class Network {
    static int answer =0;
    static void DFS(int node, boolean[] visit, int[][] computers){
        visit[node] = true;
        for(int i=0; i<computers.length; i++){
            if(visit[i] == false && computers[node][i]==1){
                DFS(i,visit, computers);
            }
        }
    }

    static int solution(int n, int[][] computers){

        boolean[] visit = new boolean[computers.length];
        for(int i=0; i<computers.length; i++){
            visit[i] = false;
        }

        for(int i=0; i<computers.length; i++){
        if(visit[i] == false){
            answer++;
            DFS(i, visit, computers);
        }
        }
        return answer;
    }

    public static void main(String[] args){
        int n= 3;
        int[][] computers = {{0, 0, 1}, {0, 0, 1}, {1, 1, 0}};


        System.out.println(solution( n,  computers));
    }
}
