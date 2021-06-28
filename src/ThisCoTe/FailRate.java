package ThisCoTe;

import java.util.ArrayList;
import java.util.Collections;


class FailNode implements Comparable<FailNode> {

    private int stage;
    private double fail;

    public FailNode(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }

    public int getStage() {
        return this.stage;
    }

    @Override
    public int compareTo(FailNode other) {
        if (this.fail == other.fail) {
            return Integer.compare(this.stage, other.stage);
        }
        return Double.compare(other.fail, this.fail);
    }
}

public class FailRate {
    public static void main(String[] args){
        ArrayList<FailNode> arrayList = new ArrayList<>();
        int n = 5;
        int[] stage = {2,1,2,6,2,4,3,3};
        int[] answer = new int[n];

        int length = stage.length;

        // 계수정렬
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for (int j = 0; j < stage.length; j++) {
                if (stage[j] == i) {
                    cnt += 1;
                }
            }
            System.out.println(cnt);


            double fail = 0;
            if (length >= 1) {
                fail = (double) cnt / length;
            }

            arrayList.add(new FailNode(i,fail));
            length -= cnt;
        }

        Collections.sort(arrayList);
//
//        for (int i = 0; i < n; i++) {
//            answer[i] = arrayList.get(i).getStage();
//            System.out.println(answer[i]);
//        }
    }
}
