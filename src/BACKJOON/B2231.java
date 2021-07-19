package BACKJOON;

import java.util.Scanner;

public class B2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int e = i;
            int sum=0;

            while (e != 0) {
                sum += e%10;
                e/=10;
            }
            if(sum + i== n){
                result=i;
                break;
            }
        }
        System.out.println(result);
    }
}
