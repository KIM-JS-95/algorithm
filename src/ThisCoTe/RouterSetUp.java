package ThisCoTe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RouterSetUp {
static ArrayList<Integer> arr = new ArrayList<>();
static int n,c;
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        n=sc.nextInt();
        c= sc.nextInt();

        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        int start = 1;
        int end = arr.get(n-1) - arr.get(0);
        int result = 0;

       System.out.println( binary(arr,start,end,result) );
    }

    public static int binary(ArrayList<Integer> arr , int start, int end, int result) {
        while (start <= end) {
            int mid = (start + end) / 2;
            System.out.println(mid);
            int router = arr.get(0);
            int cnt = 1;
            for (int i = 1; i < arr.size(); i++) {
                // 1번 라우터와 중앙 사이의 거리가 다음 위치까지 거리보다 같거나 작다면 라우터 설치할것
                if (arr.get(i) >= router + mid) {
                    cnt++;
                    router = arr.get(i);
                }

            }
            if (cnt >= c) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
