package BACKJOON;

import java.util.*;

public class B18870 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int n= sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int[] list=arr.clone();
        Arrays.sort(list);

        int cnt=0;
        for(int i=0; i<list.length; i++){
            if(!map.containsKey(list[i])){
                map.put(list[i], cnt++);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<list.length; i++){
            sb.append(map.get(arr[i]) + " ");
        }

        System.out.print(sb);
    }
}
