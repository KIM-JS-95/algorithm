

package BACKJOON;

import java.util.Scanner;

public class B1000 {
    @FunctionalInterface
    interface MyInterface{
        public int method(int a, int b);

    }

        public static void main(String[] args){
//            Scanner sc = new Scanner(System.in);
//            MyInterface fi;
//            fi=(a, b) -> {
//                int c= a+b;
//                return c;
//            };
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int c=fi.method(a,b);
//
//            System.out.println(c);

            boolean flag1 = true;
            boolean flag2 = true;

            flag1=!flag1;
            flag2=false;
            System.out.println(flag1);
            System.out.println(flag2);
        }
}
