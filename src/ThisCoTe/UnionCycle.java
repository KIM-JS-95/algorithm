// Input
//   3 3
//   1 2
//   1 3
//   2 3

// output
//  cycle

package ThisCoTe;

import java.util.Scanner;

public class UnionCycle {
    public static int e, v;
    public static int[] parent = new int[1001];

    private static int find(int x){
        if(x==parent[x]) return x; // 자기 자신의 루트 노드 라는 의미
        return parent[x]=find(parent[x]);
    }

    private static void union(int a, int b){
        a=find(a);
        b=find(b);
        if(a<b) parent[b]=a;
        else parent[a]=b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        e= sc.nextInt();
        v= sc.nextInt();

        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        boolean cycle = false;

        for(int i=1; i<=e; i++){
            int a= sc.nextInt();
            int b = sc.nextInt();

            if(find(a)==find(b)){
                cycle = true;
                break;
            }else{
                union(a,b);
            }
        }

        if(cycle)
            System.out.println("cycle");
        else
            System.out.println("Non cycle");
    }

}