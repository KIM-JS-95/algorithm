package ThisCoTe;


// In order to loot the food storage without being caught by scouts,
// the food storage must be mined at least one square away.
// Find the Max value of food you can get.

// ex) n = 4
//     arr = {1,3,1,5}
//     return = 8


import java.util.Scanner;

public class AntWorrior {

    public static int[] d=new int[100];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();

        int[] arr = new int[4];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        d[0] = arr[0];
        d[1] = Math.max(arr[0],arr[1]);

        for(int i=2; i<n; i++){
            d[i] = Math.max(d[i-1], d[i-2] + arr[i]);
        }

        for(int val : d)
            System.out.print( val+" ");
    }
}
