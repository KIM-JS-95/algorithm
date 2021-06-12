package KAKAO;

import java.util.LinkedList;
import java.util.Queue;

public class Chache {

    public static void main(String[] args){

        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(cacheSize, cities));

    }

    public static int solution(int cacheSize, String[] cities) {

        int time = 0;
        Queue<String> Q = new LinkedList<>();

        if(cacheSize == 0){
            return cities.length * 5;
        }

    for(int i = 0; i < cities.length; i++) {

        boolean hit = ((LinkedList<String>) Q).removeFirstOccurrence(cities[i].toUpperCase());
        Q.add(cities[i].toUpperCase());
        time += 1;
        if (!hit) {
            time += 4;
            if ((Q.size() > cacheSize)) {
                ((LinkedList<String>) Q).removeFirst();
            }
        }
    }
        int answer = time;
        return answer;
    }
}
