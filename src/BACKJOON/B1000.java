

package BACKJOON;

import java.math.BigInteger;
import java.util.Scanner;

public class B1000 {

        public static void main(String[] args) {
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


            // create 2 BigInteger objects
            BigInteger bi1, bi2;

            // create and assign value to exponent
            int exponent = 2;

            // assign value to bi1
            bi1 = new BigInteger("6");

            // perform pow operation on bi1 using exponent
            bi2 = bi1.pow(exponent);

            String str = "Result is " + bi1 + "^" +exponent+ " = " +bi2;

            // print bi2 value
            System.out.println( str );

        }
}
