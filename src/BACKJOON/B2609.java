package BACKJOON;

import java.util.Scanner;

public class B2609 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b= sc.nextInt();

        int c = GDC(a,b);
        System.out.println(c);
        System.out.println(LCM(a,b,c));


    }

    // 최대 공약수
    static int GDC(int a, int b){
        while(b>0){
            int temp = a;
            a=b;
            b = temp % b;
        }
        return a;
    }

    static int LCM(int a, int b, int c){
        return (a*b)/c;
    }
}
