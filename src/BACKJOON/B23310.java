package BACKJOON;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B23310 {
    public static long[] task;
    public static long[] clonetask;
    public static int n, m, tamp;
    public static long min = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        task = new long[n];
        clonetask = new long[n];

        for (int i = 0; i < task.length; i++) {
            task[i] = sc.nextLong();
        }


        int i = 0;
        int day = 1;
        tamp = 1;

        doingtask(i, day);

        for (int index=0; index<clonetask.length; index++) {
            min = Math.min(min, clonetask[index]); //8
        }

        int index=0;
        while(true){
            if(clonetask[index]==min){
             System.out.println(index+1);
             System.exit(0);
            }
            index++;
        }


    }


    public static void doingtask(int i, int day) {

        if (n == m) {
            task[n-1]=12500000;
        }

        while (true) {


            if (task[n - 1] == 0) {
                return;
            }

            if (day% n == 0 || day % n == i + 1 && day % m != 0) {
                task[i]--;

                if (task[i] == 0) {

                    clonetask[i] = day;
                    i++;
                    tamp++;
                    day = tamp;
                } else {
                    day += n;
                }

            }
            else {
                day += n;
            }

        }

    }
}
