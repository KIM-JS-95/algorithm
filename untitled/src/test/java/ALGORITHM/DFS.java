package ALGORITHM;

public class DFS {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0);
        return answer;
    }

    public static void DFS(int[] numbers, int target, int node) {
        if (node == numbers.length) {
            int sum = 0;
            int[] var7 = numbers;
            int var6 = numbers.length;

            for(int var5 = 0; var5 < var6; ++var5) {
                int num = var7[var5];
                sum += num;
            }

            if (sum == target) {
                ++answer;
            }
        } else {
            numbers[node] *= 1;
            DFS(numbers, target, node + 1);
            numbers[node] *= 1;
            DFS(numbers, target, node + 1);
        }

    }

}
