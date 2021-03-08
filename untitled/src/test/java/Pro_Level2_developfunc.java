import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pro_Level2_developfunc {

    static int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack= new Stack<>();

        for(int i=0; i<progresses.length; i++){
            stack.add((100 - progresses[i])/ speeds[i] + (100 - progresses[i])% speeds[i]);
        }

        List<Integer> list = new ArrayList<>();

        while (!stack.isEmpty()){
            int cnt =1;

            int temp = stack.pop();
            while (!stack.isEmpty() && stack.peek() <=temp){
                cnt++;
                stack.pop();
            }
            list.add(cnt);
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args){

        int[] a= {93,30,55};
        int[] b ={1,30,5};

       solution(a,b);
    }
}
