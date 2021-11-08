package BACKJOON;

import java.io.*;

public class B1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        int[] nArray = new int[t];

        for(int i=0; i<t; i++) {
            nArray[i] = Integer.parseInt(br.readLine()); // 입력할 값들
        }

        int[] zeroCount = new int[41]; // 0~40까지 값이 들어가므로 총 배열의 크기는 41
        int[] oneCount = new int[41];

        zeroCount[0] = 1; // fibonacci(0)에 대한 출력횟수는 0은 1회, 1은 0회이다.
        oneCount[0] = 0;
        zeroCount[1] = 0; // fibonacci(1)에 대한 출력횟수는 0은 1회, 1은 1회이다.
        oneCount[1] = 1;

        for(int j=2; j<41; j++) { // 설명한 로직대로 쭉쭉 값이 들어간다.
            zeroCount[j] = zeroCount[j-1] + zeroCount[j-2];
            oneCount[j] = oneCount[j-1] + oneCount[j-2];
        }

        for(int k=0; k<nArray.length; k++) {
            System.out.println(zeroCount[nArray[k]] + " " + oneCount[nArray[k]]); // 입력한 값에 맞춰 담긴 배열에서
        }

    }

}
