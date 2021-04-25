package BACKJOON;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class back_2331 {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        map.put(a,0);
        int ans = 1;
        int temp = a;

        while(true){
            int D =0;
            while(temp != 0){
                D += Math.pow(temp % 10, b);
                temp /= 10;
            }
            System.out.println("확인하세요 : "+D);
            if(map.containsKey(D)){
                System.out.println(map.get(D));
                return;
            }
            System.out.println("확인하세요 : "+map.toString());
            map.put(D,ans++);
            temp=D;
        }
    }
}
