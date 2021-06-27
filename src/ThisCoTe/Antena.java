package ThisCoTe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Antena {

    static int min = Integer.MAX_VALUE;
    static int[] d;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        sc.close();
        Collections.sort(arr);
        int mid = (n-1)/2;

        System.out.println(arr.get(mid));

    }

}


