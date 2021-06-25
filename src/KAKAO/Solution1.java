package KAKAO;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution1 {
    public static void main(String[] args){

        int[] arr ={1,2,3,4,5,6,7,8,9,10};


        int sum1 = Arrays.stream(arr).filter(i->i%2==0).sum();
        int sum2 = Arrays.stream(arr).filter(i->i%2!=0).sum();
        int total = Arrays.stream(arr).sum();
        System.out.println(sum1+" "+ sum2+" "+total);

    }

}
