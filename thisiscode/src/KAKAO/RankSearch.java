package KAKAO;

import java.util.*;

public class RankSearch {

    public static void main(String[] args) {

        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        //solution(info, query);
        for(int val : solution(info, query))
        System.out.println(val);
    }



    private static int[] solution(String[] info, String[] query) {
        Map<String, Integer> wordmap = new HashMap<>();
        List<List<Integer>> scoreList = new ArrayList<>();

        wordmap.put("-", 0);
        wordmap.put("cpp", 1);
        wordmap.put("java", 2);
        wordmap.put("python", 3);
        //4
        wordmap.put("backend", 1);
        wordmap.put("frontend", 2);
        //3
        wordmap.put("junior", 1);
        wordmap.put("senior", 2);
        //3
        wordmap.put("chicken", 1);
        wordmap.put("pizza", 2);
        //3

        for (int i = 0; i < 4 * 3 * 3 * 3; ++i)
            scoreList.add(new ArrayList<>());


        for (String str : info) {
            String[] word = str.split(" ");
            int[] arr = {wordmap.get(word[0]) *3*3*3,
                    wordmap.get(word[1]) *3*3,
                    wordmap.get(word[2]) *3,
                    wordmap.get(word[3])};

            int score = Integer.parseInt(word[4]);

            for (int i = 0; i < (1 << 4); i++) {
                int idx = 0;
                for (int j = 0; j < 4; ++j) {
                if((i & (1<<j)) !=0){
                    idx += arr[j];
                }
                }

                scoreList.get(idx).add(score);
            }
        }

        for (int i = 0; i < 4*3*3*3; ++i) {
        Collections.sort(scoreList.get(i));
        }

        int[] answer = new int[query.length];

        for(int i=0; i< query.length; i++){
            String[] word =query[i].split(" ");
            int idx = wordmap.get(word[0]) *3*3*3 +
                    wordmap.get(word[2])  *3*3 +
                    wordmap.get(word[4]) *3 +
                    wordmap.get(word[6]);

            int score = Integer.parseInt(word[7]);

            int ret=Collections.binarySearch(scoreList.get(idx), score);

            if(ret <0){
                ret = -(ret +1);
            }else{
                for(int j=ret -1; j>=0; --j){
                    if(scoreList.get(idx).get(j)==score){
                        ret = j;
                    }else{
                        break;
                    }
                }
            }

            answer[i]= scoreList.get(idx).size() -ret;
        }
            return answer;
        }

    }

