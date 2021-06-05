package ThisCoTe;

import java.util.Scanner;

public class tile {

    public static int[] d = new int[100];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        d[1] = 1;
        d[2] = 3;

        for(int i=3; i<=n; i++){
            d[i] = (d[i-1] + d[i-2] * 2);
        }

        for(int val : d){
            System.out.print(val +" ");
        }
    }
}
