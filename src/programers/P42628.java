package programers;

import java.util.Collections;
import java.util.PriorityQueue;

public class P42628 {

    public static void main(String[] args) {
        String[] operations = {"I 7","I 5","I -5","D -1"};


        solution(operations);
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        PriorityQueue<Integer> QR = new PriorityQueue<>(Collections.reverseOrder());

        int[] answer = {0, 0};

        for(int i=0; i< operations.length; i++){
            String temp[] = operations[i].split(" ");

            switch (temp[0]) {
                case "I":
                    Q.add(Integer.parseInt(temp[1]));
                    QR.add(Integer.parseInt(temp[1]));
                    break;

                case "D":
                    if (Q.size() > 0) {
                        if (Integer.parseInt(temp[1]) == 1) {
                            Q.remove(QR.poll());
                        } else {
                            Q.remove(Q.poll());
                        }
                        break;
                    }
            }
        }

        if(Q.size()>=2){
            answer[0] = QR.poll();
            answer[1] = Q.poll();
        }
        System.out.println(answer[0] +":"+answer[1]);

        return answer;
    }
}
