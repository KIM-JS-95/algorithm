package QUESTION;

import java.util.*;

public class num1 {

    public static void main(String[] args) {


        String company_code = "012345";
        String day = "20190620";
        String[] data = {"price=80 code=987654 time=2019062113", "price=90 code=012345 time=2019062014", "price=120 code=987654 time=2019062010",
                "price=110 code=012345 time=2019062009", "price=95 code=012345 time=2019062111"};

        solution(company_code, day, data);
    }

    public static int[] solution(String code, String day, String[] data) {
        Queue<String> q = new LinkedList<>();

        String[] list = new String[data.length];

        String[] data1 = new String[data.length];
        for(int i=0; i<data.length; i++) {
          String[] arr1= data[i].split(" ");
            list[i] = arr1[2].substring(5);
           // System.out.println(list[i]);
        }
        Arrays.sort(list);

        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data.length; j++)
            if(data[j].contains(list[i]))
            data1[i] = data[j];
        }
//        for(String val : data1){
//            System.out.println(val);
//        }

        int[] answer = new int[2];
        for (int i = 0; i < data.length; i++) {
           String[] arr = data1[i].split(" ");
            if (data1[i].contains(code) && data1[i].contains(day)) {
                q.add(arr[0].substring(6));

                System.out.println(arr[0].substring(6));
            }

        }
        int k=0;
        while(!q.isEmpty()){
            answer[k]= Integer.parseInt(q.poll());
            k++;
        }

        return answer;
    }
}

