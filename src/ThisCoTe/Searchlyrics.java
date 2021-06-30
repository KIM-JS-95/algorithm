package ThisCoTe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Searchlyrics {
    public static void main(String[] args){
        String[] words = {"frodo","front","frost","frozen","frame","kakao"};
        String[] queries ={"fro??","????o","fr???","fro???","pro?"};

        for(int val : solutions(words, queries))
        System.out.println(val);
    }

    static ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> reversedArr = new ArrayList<ArrayList<String>>();

    private static int[] solutions(String[] words, String[] queries) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < 10001; i++) {
            arr.add(new ArrayList<String>());
            reversedArr.add(new ArrayList<String>());
        }

        for(int i=0; i< words.length; i++){
            String word = words[i];
            arr.get(word.length()).add(word);
            word = (new StringBuffer(word)).reverse().toString();
            reversedArr.get(word.length()).add(word); // 단어를 뒤집어서 삽입
        }
        for (int i = 0; i < 10001; i++) {
            Collections.sort(arr.get(i));
            Collections.sort(reversedArr.get(i));
        }

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int res = 0;
            if (q.charAt(0) != '?') { // 접미사에 와일드 카드가 붙은 경우
                res = countByRange(arr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
            }
            else { // 접두사에 와일드 카드가 붙은 경우
                q = (new StringBuffer(q)).reverse().toString();
                res = countByRange(reversedArr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
            }
            // 검색된 단어의 개수를 저장
            ans.add(res);
        }
        // 배열로 바꾸어 반환
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    public static int countByRange(ArrayList<String> arr, String leftValue, String rightValue) {
        int rightIndex = upperBound(arr, rightValue, 0, arr.size());
        int leftIndex = lowerBound(arr, leftValue, 0, arr.size());
        return rightIndex - leftIndex;
    }


    public static int lowerBound(ArrayList<String> arr, String target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            // arr[mid]가 target보다 사전순으로 같거나 뒤에 있다면
            if (arr.get(mid).compareTo(target) >= 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int upperBound(ArrayList<String> arr, String target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            // arr[mid]가 target보다 사전순으로 뒤에 있다면
            if (arr.get(mid).compareTo(target) > 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}
