package BACKJOON;

import java.util.Scanner;

public class B3039 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int A = arr[0];

        for(int i=1; i<n; i++){
            printFraction(reduceFraction(A,arr[i]));
        }
    }

    public static void printFraction(int[] bunsu) {
        System.out.format("%d/%d%n", bunsu[0], bunsu[1]);
    }


    public static int[] reduceFraction(int bunja, int bunmo) {
        int[] frac = new int[2];
        frac[0] = bunja;
        frac[1] = bunmo;

        if (frac[1] == 0) { // 분모가 0일 경우에 에러 반환
            frac[0] = 0;
            frac[1] = 0;
            return frac;
        }
        int gcd_result = GDC(frac[0], frac[1]);

        frac[0] = frac[0] / gcd_result;
        frac[1] = frac[1] / gcd_result;

        return frac;

        }

    public static int GDC(int a, int b){

        while (b>0){
            int temp =a % b;
            a=b;
            b=temp;
        }
        return a;
    }
}
