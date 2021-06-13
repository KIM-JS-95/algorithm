package QUESTION;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class num2 {
    public static void main(String[] args) {
        int[] t = {0, 1, 3, 0};
        int[] r = {0,1,2,3};

        solution(t,r);
    }

    public static int[] solution(int[] t, int[] r) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<t.length; i++){
            stack.push(t[i]);

            map.put(i,t[i]);
        }

        Iterator<Integer> keys = map.keySet().iterator();
        while( keys.hasNext() ){
            Integer key = keys.next();
            Integer value = map.get(key);
            System.out.println("키 : "+key+", 값 : "+value);
        }

        int[] answer = new int[t.length];

        for(int i=0; i<stack.size(); i++){
            int temp = stack.pop();
            int change = stack.peek();
           // System.out.println(temp);
            if(temp > change){
            answer[i]=getKey(map,temp); //key
            System.out.println(i+": "+ answer[i]);
            }else if(temp < change){
                answer[i]=getKey(map,change);
              //  System.out.println(i+": "+ answer[i]);
                stack.add(temp);
            }
        }

//        for(int val : answer)
//            System.out.println(val);

        return answer;
    }

    public static Integer getKey(Map<Integer, Integer> m, Integer value) {

        for(Integer o: m.keySet()) {

            if(m.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

}
