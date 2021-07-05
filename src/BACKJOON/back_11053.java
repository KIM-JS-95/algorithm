package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int d[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.fill(d,1);
//        for(int i=1; i<n; i++){
//            for(int j=0; j<i; j++){
//                if(arr[j]<arr[i] && d[i] <= d[j])
//                d[i] = d[j]+1;
//            }
//        }
//
//        int max = 0;
//        for(int i: d){
//            max = Math.max(i,max);
//        }
//
//        System.out.println(max);

        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < n; i++) {
            int value = arr[i];
            if(value > list.get(list.size() - 1)) list.add(value);
            else{
                int left = 0;
                int right = list.size() - 1;

                while(left < right){
                    int mid = (left + right) >> 1;
                    if(list.get(mid) >= value){
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                list.set(right, value);
            }
        }
        System.out.println(list.size() - 1);
    }
}
