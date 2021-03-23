import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortBignumber {
    public static String solution(int[] number) {
        StringBuilder sb =  new StringBuilder();
        List<Integer> list = new ArrayList<>();

        String[] nums = new String[number.length];

        for (int i=0; i<nums.length; i++)
            nums[i] = number[i] + "";

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        String answer = "";

        for(int i=0; i<number.length; i++){
            answer += nums[i];
        }


        return answer.charAt(0)== '0' ? "0" : answer;
    }

    public static void print(String number){
        System.out.println(number);
    }

    public static void main(String[] args){
        int[] number = {6,10,2};
        String a= solution(number);
        print(a);

    }
}
