package KAKAO;

import java.util.ArrayList;
import java.util.HashMap;

public class 압축 {

    public static void main(String[] args){
        String msg = "TOBEORNOTTOBEORTOBEORNOT";

        solution(msg);
    }


        public static int[] solution(String msg) {
            HashMap<String, Integer> map = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();

            char ch = 'A';
            for(int i = 1; i<27;i++){
                map.put(ch +"",i);
                ch +=1;
            }

            for(int i=0; i<msg.length(); i++){
                String w = msg.substring(i, i+1); // K
                int id = i+1;
                while(id<msg.length()){
                    String c = msg.substring(id,id+1);  // A
                    String temp = w+c; // KA

                    if(map.containsKey(temp)){
                        w = temp;
                        i++;
                        id++;
                    }
                    else{
                        map.put(temp, map.size()+1);
                        break;
                    }
                }
                list.add(map.get(w));
            }


            int[] answer = new int[list.size()];
            for(int i=0; i<answer.length; i++){
                answer[i] = list.get(i);
            }
            return answer;
        }
    }

