package BACKJOON;

import java.util.Scanner;

public class B1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();

       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;
       while(n-- >0){
           int t = sc.nextInt();

           if(min>t) min=t;

           if(max<t) max = t;
       }

       System.out.println(min * max);
    }
}
