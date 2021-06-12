package KAKAO;



public class Solution1 {
    public static void main(String[] args){
        int[] gift={4, 5, 3, 2, 1};
        int[] want=	{2, 4, 4, 5, 1};
        System.out.println(solution(gift,want));


    }


    public static int solution(int[] gift, int[] want){
        int answer=0;
        for(int i=0; i<gift.length; i++){
            for(int j=0; j<want.length; j++){
                if(gift[i]==want[j]){
                    int temp =gift[i];
                    gift[i] = gift[j];
                    gift[j] = temp;
                }
            }
        }
        for(int i=0; i<gift.length; i++){
           if(gift[i]!=want[i]){
               answer++;
           }
        }

//        for(int i=0; i<gift.length; i++){
//            System.out.println(gift[i]);
//        }


        return answer;
    }
}
