package ALGORITHM;

import java.util.Scanner;

public class freeNode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String bi = Integer.toBinaryString(n);
        char[] bichar = bi.toCharArray();

        int total = 0;
        int gab = 0;

        for(int i=0; i<bichar.length; i++){
            if(bichar[i]=='1'){
                if(total<gab) total = gab;
                gab=0;
            }else{
                gab++;
            }
        }
        System.out.print(total);
    }
}
