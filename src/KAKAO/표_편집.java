package KAKAO;


import java.util.Stack;

// 커서 위차정보
public class 표_편집 {
public static void main(String[] args){
    int n = 8; // 테이블 크기
    int k=2;// 커서 위치

    String[] cmd= {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};

    System.out.println(solution(n,k,cmd));
}

public static String solution(int n, int k, String[] cmd) {
    Stack<Integer> stack = new Stack<Integer>();
    int table = n;

    for (int i = 0; i < cmd.length; i++) {
        char c = cmd[i].charAt(0); // D, C, U, D, C, U, Z, Z

    switch (c) {
        case 'U':
            k -= Integer.valueOf(cmd[i].substring(2));
            break;
        case 'D':
            k += Integer.valueOf(cmd[i].substring(2));
            break;
        case 'C':
            stack.push(k);
            n--;
            if (k == n) k--; // 커서의 위치가 마지막에 위치한다면 내려주어야함
            break;
        case 'Z':
            int r = stack.pop();
            if (k >= r) k++; //커서위치에서 한칸 위의 위치에 삽입
            n++;
            break;
    }
}
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<n; i++){
        sb.append("O");
    }
    while(!stack.isEmpty()){
        sb.insert(stack.pop().intValue(), "X");
    }

    return sb.toString();
}

}
