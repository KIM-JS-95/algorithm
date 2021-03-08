public class Target_number {

    static int DFS(int[] numbers, int target, int node, int sum){
        if(node == numbers.length){
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        return DFS(numbers, target, node+1,sum+numbers[node]) + DFS(numbers, target, node+1,sum-numbers[node]);
    }

    public static void main(String[] args){

        int[] numbers = {1,1,1,1,1};
        int target = 3;
        DFS(numbers, target, 0,0);
    }
}
