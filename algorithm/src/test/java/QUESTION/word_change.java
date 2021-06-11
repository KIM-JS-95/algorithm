package QUESTION;

public class word_change {

    static int minCnt = Integer.MAX_VALUE;
    static void DFS(String[] words,String begin,String target, int cnt, boolean[] visited){
        if(begin.equals(target)){
            if(minCnt>cnt)
                minCnt=cnt;
            return;
        }

        for(int i=0;i<words.length;i++){
            if(!visited[i] && checkWords(begin,words[i])){
                visited[i]=true;
                DFS(words,words[i],target,cnt+1,visited);
                visited[i]=false;
            }
        }
    }

    private static boolean checkWords(String begin, String target) {
        char[] a=begin.toCharArray();
        char[] b=target.toCharArray();
        int change=0;

        for(int i=0; i<a.length;i++){
            if(a[i] != b[i])
                change++;
        }

        if(change==1) return true;

        return false;
    }

    static int solution(String begin, String target, String[] words) {

        DFS(words, begin, target, 0,  new boolean[words.length]);

        if(minCnt==Integer.MAX_VALUE)
            minCnt=0;

        return minCnt;
    }

    public static void main(String[] args) {
        String begin = "1234567000";
        String target = "1234567899";
        String[] words = { "1234567800", "1234567890", "1234567899"};


        solution(begin,target,words);


        System.out.println(minCnt);
    }

}
