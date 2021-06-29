package ThisCoTe;

import java.util.Scanner;

public class FindSearchPoint {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int[] arr =new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = n;
        System.out.println( binary(arr, start, end) );
    }

    private static int binary(int[] arr, int start, int end) {
        if(start>end) return -1;

        int mid = (start+end)/2;
        if(arr[mid]==mid) return mid;
        else if(arr[mid]>mid) return binary(arr, start, mid-1);
        else return binary(arr, mid+1, end);
    }
}
