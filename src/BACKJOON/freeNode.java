package BACKJOON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class freeNode {
    public static void main(String args[]) throws IOException {

       String s = "abcxyasdfasdfxyabc";
        solution(s);
    }

    public static String[] solution(String s) {
        String[] answer = {};
        List<String> list = new ArrayList<String>();

        while(true) {
            String tempStr = seqCompare(s,list);
            if( "1".equals(tempStr) ){
                list.add(s);
                break;
            }
            s = tempStr;
        }

        if(list.contains("")) {
            list.remove("");
            answer = new String[ list.size() * 2];

            for(int i=0; i<list.size(); i++) {
                answer[i] = list.get(i);
                answer[answer.length-i-1] = list.get(i);
            }

        }
        else {
            answer = new String[list.size() * 2 - 1];

            for(int i=0; i<list.size()-1; i++) {
                answer[i] = list.get(i);
                answer[answer.length-i-1] = list.get(i);
            }

            answer[answer.length/2] = list.get(list.size()-1);

        }

//        for(String val : answer)
//            System.out.println(val);

        return answer;

    }

    public static String seqCompare(String s , List<String> list) {
        int len = s.length();
        for(int i=1; i<len && len-i>=i ; i++) {
            if(s.substring(0,i).equals(s.substring(len-i))) {
                list.add(s.substring(0,i));
                return s.substring(i,len-i);
            }
        }

        return "1";
    }

}

