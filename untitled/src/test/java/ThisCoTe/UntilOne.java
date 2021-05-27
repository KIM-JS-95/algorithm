package ThisCoTe;

import java.util.Scanner;

public class UntilOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = 0;

        while (true) {
            int target = (N / M) * M;

            //System.out.println(target);

            answer += (N - target);
            N = target;

            if(N<M) break;

            answer +=1;
            N /=M;

            System.out.println(answer);
            //System.out.println(N);
        }

        answer += N-1;
        System.out.println(answer);

    }

}
