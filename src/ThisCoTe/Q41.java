package ThisCoTe;

import java.util.ArrayList;
import java.util.Scanner;

public class Q41 {
    static int[] parent = new int[10001];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int x= sc.nextInt();
                if(x==1){
                    union(i+1, j+1);
                }
            }
        }

        ArrayList<Integer> plan = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            plan.add(x);
        }


        boolean result = true;
        // 여행 계획에 속하는 모든 노드의 루트가 동일한지 확인
        for (int i = 0; i < m - 1; i++) {
            if (find(plan.get(i)) != find(plan.get(i + 1))) {
                result = false;
            }
        }

        // 여행 계획에 속하는 모든 노드가 서로 연결되어 있는지(루트가 동일한지) 확인
        if (result) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a<b) parent[b]=a;
        else parent[a]=b;
    }

    public static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
