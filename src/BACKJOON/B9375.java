package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B9375 {


    public static void main(String[] args){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

        try {
            int t = Integer.parseInt(br.readLine());

            while (t -->0){
                HashMap<String, Integer> hash = new HashMap<>();

                int n = Integer.parseInt(br.readLine());

                // 의류정보 입력 받기
                while(n --> 0){
                    StringTokenizer st =new StringTokenizer(br.readLine(),  " ");
                st.nextToken();

                String kind = st.nextToken();

                if(hash.containsKey(kind)){
                    hash.put(kind, hash.get(kind)+1);
                }else{
                    hash.put(kind, 1);
                }
                }

                int result =1;

                // 3C1 * 2C1
                for(int val : hash.values()){
                    result *= val+1;
                }

                sb.append(result-1).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sb);
    }
}
