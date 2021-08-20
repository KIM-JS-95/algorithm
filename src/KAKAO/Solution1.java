package KAKAO;


import java.util.*;

public class Solution1 {
   static int nv;
   static double nl,nr,nb,nt;

    public static void main(String[] args) {
        int[] x = {3,4};
        int[] y = {3,5};
        int[] r = {2,3};
        int[] v = {12, 83, 54, 35, 686, 337, 258, 95, 170, 831, 8, 15};
        solution(x, y, r, v);
    }


    public static int solution(int[] x, int[] y, int[] r, int[] v) {
        List<Double> list = new ArrayList<>();
        int size = r.length;
        nv = v.length / 2;


           // System.out.println("좌표 " + targetX + " " + targetY + " " +targetR);

            nl = x[0] - r[0];
            nr = x[1] + r[0];
            nb = y[0] - r[1];
            nt = y[1] + r[1];

            System.out.println(nl+" "+nr+" "+nb+" "+nt);

            for (int i = 0; i < v.length; i++) {
                if (i % 2 == 0) {
                    double nx = nl + v[i] % (nr - nl);
                    double ny = nb + v[i + 1] % (nt - nb);
                  //  System.out.println("변환 " + nx + " " + ny + " ");

//                    for(int w=0; w<size; w++) {
//                        double radi = (Math.sqrt((Math.pow((r[w] - nx), 2)) + (Math.pow((r[w] - ny), 2))));
//                        for (int u = 0; u < size; u++) {
//                            if (radi <= r[0] && radi <= r[1]) {
//                                list.add(radi);
//                            }
//                        }
//                    }

                }


            }

            System.out.println("---------------------");

            double si = list.size();
             System.out.println("사이즈 " + si);

        double k = si / nv;
       // System.out.println(k);
        int answer = (int)((si / nv) * (nr - nl) * (nt - nb));

       // System.out.println(answer);
        return answer;
    }

}
