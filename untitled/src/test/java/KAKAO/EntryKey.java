package KAKAO;

import java.util.*;

public class EntryKey {
    public static void main(String[] args) {
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        //solution(relation);
        System.out.println(solution(relation));
    }


    public static Comparator<Integer> comp = new Comparator<Integer>() {
        public int countBits(int n) {
            int ret = 0;
            while (n != 0) {
                if ((n & 1) != 0) ++ret;
                n = n >> 1;
            }
            return ret;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            int x = countBits(o1);
            int y = countBits(o2);

            if (x > y) {
                return 1;
            } else if (x < y) {
                return -1;
            } else
                return 0;
        }
    };

    static boolean check(String[][] relation, int rowsize, int colsize, int subset) {

        for (int a = 0; a < rowsize - 1; a++) {
            for (int b = a + 1; b < rowsize; b++) {
                boolean isSame = true;
                for (int k = 0; k < colsize; k++) {
                    if ((subset & 1 << k) == 0) continue;
                    if (relation[a][k].equals(relation[b][k]) == false) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) return false;
            }
        }
        return true;
    }


    public static int solution(String[][] relation) {
        int answer = 0;
        List<Integer> candidates = new LinkedList<Integer>();
        int rowsize = relation.length;
        int colsize = relation[0].length;


        for (int i = 1; i < 1 << colsize; i++) {
            if (check(relation, rowsize, colsize, i) == true) {
                candidates.add(i);
            }
        }
        Collections.sort(candidates, comp);

        while (candidates.size() != 0) {
            int n = candidates.remove(0);
            answer++;

            for (Iterator<Integer> it = candidates.iterator(); it.hasNext(); System.out.println(it.hasNext())) {
                int c = it.next();
                if ((n & c) == n)
                    it.remove();
            }
        }

        return answer;
    }
}
