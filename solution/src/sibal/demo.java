package sibal;

import java.util.*;
class Solution {
    public String solution(String number, int k) {
        
       char[] input = number.toCharArray();
        
         Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<input.length; i++){
            while(!stack.empty() && k >0 && stack.peek() < input[i]){
                k--;
                stack.pop();
            }
            stack.push(input[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            if(k != 0){
                stack.pop();
                k--;
            }else{
                sb.append(stack.pop());
            }
        }       
        return sb.reverse().toString();
    }
}