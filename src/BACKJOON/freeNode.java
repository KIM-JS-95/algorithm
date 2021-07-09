package BACKJOON;


import java.util.*;
import java.util.stream.Collectors;

class Node{
    String name;
    int num;

    public Node(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
public class freeNode {
    public static void main(String args[]) {

        String[] s = {"mislav", "stanko", "mislav", "ana"};
        String[] com = {"stanko", "ana", "mislav"};
        solution(s, com);
    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(i=0; i< completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }

}

