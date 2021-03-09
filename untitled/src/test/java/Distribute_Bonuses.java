

public class Distribute_Bonuses {

    static int[] solution(int[] input, int[] output) {

        for (int i = 1; i < input.length; i++) {
           // System.out.println("sdd");
            if (input[i - 1] < input[i]) {
                output[i] = output[i - 1] + 1;
            }
        }

        for (int i = input.length-2; i <= -1; i--) {
            System.out.println("sdd");
            if (input[i + 1] < input[i]) {
                output[i] = Math.max(output[i], output[i + 1] +1);
            }
        }

        for(int val : output){
            System.out.println(val);
        }
        return output;
    }

        public static void main(String[]args){
            int[] a = {1,2,3,2,3,5,1};
            int[] b = {1,1,1,1,1,1,1};

            solution(a,b);

        }
    }
