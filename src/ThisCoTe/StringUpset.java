package ThisCoTe;

import java.util.Scanner;

public class StringUpset {

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        String n = sc.next();
        int ToOne =0;
        int ToZero =0;

        if(n.charAt(0) == '0'){
            ToOne++;
        }else {
            ToZero++;
        }

        for(int i=0; i<n.length()-1; i++){
            if(n.charAt(i) == n.charAt(i+1)){
                if(n.charAt(i+1)=='1'){
                    ToZero++;
                }else{
                    ToOne++;
                }
            }
            System.out.println(ToOne + " " + ToZero);
        }

        System.out.println(Math.min(ToOne,ToZero));

    }
}
