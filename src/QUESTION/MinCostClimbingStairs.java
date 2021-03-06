package QUESTION;


public class MinCostClimbingStairs {
    public static int minCost(int[] cost) {
        int case1 = 0, case2 = 0, current;
        for (int i = cost.length - 1; i >= 0; --i) {
        current = cost[i] + Math.min(case1, case2);
        case2= case1;
        case1 =current;
        }
        return Math.min(case1, case2);
    }
    public static void main(String[] args){
    int[] cost = new int[] {10, 15, 20};
    int result = minCost(cost);
        System.out.println("===============================");
    System.out.println("answer : " + result);
        System.out.println("===============================");
    }
}
