package algorithm.백준;

import java.util.Scanner;

public class back_2839 {

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int T= sc.nextInt();
            int count=0;

            while(true)
            {
                if(T%5==0){
                    System.out.println(T/5 +count);
                    break;
                }else if(T<=0){
                    System.out.println(-1);
                    break;
                }
                T=T-3;
                count++;
            }
        }
    }