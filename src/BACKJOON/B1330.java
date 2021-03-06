package BACKJOON;

import java.util.Scanner;

public class B1330 {
    @FunctionalInterface
    interface MyInterface{
        public String method(int a, int b);

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MyInterface fi;
        fi=(a, b) -> {
            if(a==b)
                return "==";
            else {
                String c = (a >= b) ? ">" : "<";
                return c;
            }
        };
        int a = sc.nextInt();
        int b = sc.nextInt();
        String c=fi.method(a,b);

        System.out.println(c);
    }
}
