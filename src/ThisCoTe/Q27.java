package ThisCoTe;

import java.util.Scanner;

public class Q27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int target = sc.nextInt();

        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

    int cnt = right(arr,target,0,arr.length)-left(arr,target,0,arr.length);

        if(cnt >0)
        System.out.println(cnt);
        else{
            System.out.println(-1);
        }
    }

    public static int left(int[] arr, int target, int start, int end){
        while(start<end){
            int mid = (start+end)/2;

            if(arr[mid]>=target) end = mid;
                else start =mid+1;
        }
        return end;
    }

    public static int right(int[] arr, int target, int start, int end){
        while(start<end){
            int mid = (start+end)/2;

            if(arr[mid]>target) end = mid;
            else start =mid+1;
        }
        return end;
    }
}
