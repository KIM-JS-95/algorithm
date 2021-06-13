package KAKAO;

import java.util.*;

public class Openchat {

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi","Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        for(String val : solution(record)) {
            System.out.println(val);
        }
    }

    public static String[] solution(String[] record) {
        List<String> list = new ArrayList<String>();
        Map<String, String> map = new HashMap<String, String>();

        for(String str : record){
            StringTokenizer tokenizer = new StringTokenizer(str);
            String cmd = tokenizer.nextToken();

            if(cmd.equals("Enter") || cmd.equals("Change")){
                String id = tokenizer.nextToken();
                String name = tokenizer.nextToken();
                map.put(id, name);

            }
        }

        for(String str : record){
            StringTokenizer tokenizer = new StringTokenizer(str);
            String cmd = tokenizer.nextToken();

            if(cmd.equals("Enter")){
                String id = tokenizer.nextToken();
                list.add(map.get(id) + "in..");
            }else if(cmd.equals("Leave")){
                String id = tokenizer.nextToken();
                list.add(map.get(id)+ "out.");
            }
        }

        String[] answer = new String[list.size()];
        list.toArray(answer);
        return answer;
    }

}
