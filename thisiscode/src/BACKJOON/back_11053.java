package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        int[] LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = seq[0];
        int idx = 1;

        for(int i = 1; i < N; i++) {
            if(LIS[idx - 1] < seq[i]) {
                LIS[idx++] = seq[i];
            }
            else if(LIS[0] > seq[i]) {
                LIS[0] = seq[i];
            }
            else {
                int temp = Arrays.binarySearch(LIS, 0, idx, seq[i]);
                LIS[temp < 0 ? -(temp + 1) : temp] = seq[i];
            }
        }
        System.out.println(idx);
    }
}
