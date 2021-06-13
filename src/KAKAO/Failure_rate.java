package KAKAO;

import java.lang.reflect.Array;
import java.util.*;

public class Failure_rate {

    public static void main(String[] args) {

        int n = 5;
        int[] stage = {2, 1, 2, 6, 2, 4, 3, 3};

        solution(n, stage);
    }

    public static int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        HashMap<Integer, Double> failmap = new HashMap<Integer, Double>();

        for (int i = 1; i <= N; i++) {
            int stage = i;
            int incompletePlayers = 0;
            int curretStageTotalPlayers = 0;

            for (int j = 0; j < stages.length; j++) {
                int player = stages[j];
                if (stage == player) {
                    incompletePlayers++;
                }
                if (player >= stage) {
                    curretStageTotalPlayers++;
                }
            }

            double failureRate = 0;
            if (incompletePlayers != 0 && curretStageTotalPlayers != 0) {
                failureRate = (incompletePlayers / (double) curretStageTotalPlayers);
            }
            failmap.put(stage, failureRate);
        }

        for (int i = 0; i < N; i++) {
            double max = -1;
            int maxkey = 0;
            for (Integer key : failmap.keySet()) {
                if (max < failmap.get(key)) {
                    max = failmap.get(key);
                    maxkey = key;
                }
            }
            answer[i] = maxkey;
            failmap.remove(maxkey);
        }
        return answer;
    }

}
