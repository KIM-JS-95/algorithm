package programers;
import java.util.*;
public class B42888 {
    public String[] solution(String[] record) {
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
                list.add(map.get(id) + "님이 들어왔습니다.");
            }else if(cmd.equals("Leave")){
                String id = tokenizer.nextToken();
                list.add(map.get(id)+ "님이 나갔습니다.");
            }
        }

        String[] answer = new String[list.size()];
        list.toArray(answer);
        return answer;
    }
}

