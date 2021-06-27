// <연산자 끼워넣기>
// 입력된 정수의 순서는 바뀌지 않습니다.
// +,-,*,/ 연산자를 사용하여 만들어 낼 수 있ㅈ는 최댓값과 최솟값을 구하세요
// 연산은 순서 상관 없이 앞에서부터 실행합니다.
// 마지막 입력 정보는 연산자의 갯수입니다.

// 3
// 3 4 5
// 0 0 1 0
package ThisCoTe;

import java.util.ArrayList;
import java.util.Scanner;

public class OperatorInsert {

    public static int plus, minus, multi, div;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;
    public static int n;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        plus= sc.nextInt();
        minus= sc.nextInt();
        multi= sc.nextInt();
        div= sc.nextInt();

        dfs(arr.get(0), 1);
        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int now, int i) {
        if (n == i) {
            max = Math.max(max, now);
            min = Math.min(min, now);
        } else {
            if (plus > 0) {
                plus--;
                dfs(now+arr.get(i), i + 1);
                plus++;
            }
            if (minus > 0) {
                minus--;
                dfs(now-arr.get(i), i + 1);
                minus++;
            }
            if (multi > 0) {
                multi--;
                dfs(now*arr.get(i), i + 1);
                multi++;
            }
            if (div > 0) {
                div--;
                dfs(now/arr.get(i), i + 1);
                div++;
            }
        }
    }
}
