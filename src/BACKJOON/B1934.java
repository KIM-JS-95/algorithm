package BACKJOON;

import java.util.Scanner;

public class B1934 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            int c = GDC(a,b);

            System.out.println(LCM(a,b,c));
        }
    }

    public static int GDC(int a, int b){

        while (b>0){
            int temp =a;
            a=b;
            b=temp%b;
        }
        return a;
    }

    public static int LCM(int a, int b, int c){

        return (a*b)/c;
    }
}
