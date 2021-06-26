package ThisCoTe;


import java.util.*;

class Virustest implements Comparable<Virustest> {

    private int index;
    private int x;
    private int y;
    private int sec;

    public Virustest(int index, int x, int y, int sec) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.sec = sec;
    }

    @Override
    public int compareTo(Virustest o) {
        if (this.index < o.index) {
            return -1;
        }
        return 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIndex() {
        return index;
    }

    public int getSec() {
        return sec;
    }
}

public class CompetitionInpection {
    public static int[][] graph = new int[100][100];
    public static ArrayList<Virustest> virustests = new ArrayList<Virustest>();
    public static int[] dx= {-1,0,0,1};
    public static int[] dy= {0,1,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] != 0) {
                    virustests.add(new Virustest(graph[i][j],i, j, 0));
                }
            }
        }

        //Collections.sort(virustests);
        Queue<Virustest> q = new PriorityQueue<>();

        for(int i = 0; i< virustests.size(); i++){
            q.add(virustests.get(i));
        }

        int s=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();

        while(!q.isEmpty()){
            Virustest virustest = q.poll();
            for(int i=0; i<4; i++) {
                int nx= virustest.getX() + dx[i];
                int ny= virustest.getY() + dy[i];

                if (virustest.getSec() == s) break;
                if(nx>=0 && nx<=n && ny>=0 && ny<=n) {
                    if(graph[nx][ny]==0){
                        graph[nx][ny]= virustest.getIndex();
                        q.offer(new Virustest(virustest.getIndex(), nx, ny, virustest.getSec()+1));
                    }
                }

            }
        }
        System.out.println(graph[x - 1][y - 1]);
    }
}
