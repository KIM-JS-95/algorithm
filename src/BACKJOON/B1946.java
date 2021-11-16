package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int T= Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int count =Integer.parseInt(br.readLine());
            int[] paper = new int[count];
            int[] interview=new int[count];

            ArrayList<Applicant> list=new ArrayList<>();

            for(int j=0; j<count; j++) {
                str = new StringTokenizer(br.readLine());
                paper[j] = Integer.parseInt(str.nextToken());//서류
                interview[j] = Integer.parseInt(str.nextToken());//면접

                list.add(new Applicant(paper[j], interview[j]));
            }

            Collections.sort(list, new Comparator<Applicant>() {
                @Override
                public int compare(Applicant o1, Applicant o2) {
                    return o1.paper < o2.paper ? -1 : 1;
                }
            });

            int ans=count;
            int in=list.get(0).interview;
            for(int j=1; j<list.size(); j++) {

                int cur=list.get(j).interview;
                if(in < cur){
                    ans--;
                }
                if(in > cur)
                    in=cur;
            }

            System.out.println(ans);

        }
    }

}

class Applicant {
    int paper;
    int interview;

    Applicant(int paper, int interview) {
        this.paper = paper;
        this.interview = interview;
    }
}