package ThisCoTe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class AdventureTime {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        int cnt = 0;
        int result =0;
        for(int i=0; i<list.size(); i++){
            cnt++;
            if(cnt >= list.get(i)){
                cnt=0;
                result++;
            }
        }

        System.out.println(result);
    }

}
