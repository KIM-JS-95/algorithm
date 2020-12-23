import java.util.*;

public class Kth_number {
    public static int[] solution(int[] array, int[][] commands) {
        Stack<Integer> stack= new Stack<Integer>();
        ArrayList list = new ArrayList();
        int[] answer = new int[commands.length] ;
        int k=0;


        while(true) {
            if(commands.length==k){
                k=0;
                break;
            }

            int start = commands[k][0];
            int end = commands[k][1];
            int tartget = commands[k][2];
            int[] arr = new int[end-start+1];


            for (int i = start; i <= end; i++) {
                stack.add(array[i-1]);
            }

            for(int j=0; j<arr.length; j++){
                arr[j]=stack.pop();
            }
            Arrays.sort(arr);

            for(int data : arr)
                list.add(data);

            answer[k]= (int) list.get(tartget-1);

            list.removeAll(list);
            k++;
        }

        return answer;
    }
}