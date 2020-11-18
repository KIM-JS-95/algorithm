package sibal;

import java.util.*;
class Solution {

	static int bfMatch(String txt, String pat) {
	int pt=0; //커서 위치
	int pp=0; //커서 위치
	
	while(pt != txt.length() && pp != pat.length()) {
		if(txt.charAt(pt) == pat.charAt(pp)) {
			pt++;
			pp++;
		}else {
			pt =pt - pp +1;
			pp =0;
		}
	}
	
	if(pp == pat.length()) // successfully search!
		return pt-pp;
	return -1;  // failed to success
	}
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("텍스트: ");
    	String s1 =sc.next();
    	
    	System.out.println("패턴: ");
    	String s2 =sc.next();
    	
    	int idx = bfMatch(s1,s2);
    	
    	if(idx ==-1) { //if failed to success
    		System.out.println("텍스트가 존재하지 않습니다.");
    	}else {
    		int len =0;
    		for(int i=0; i<idx; i++) {
    			len +=s1.substring(i,i+1).getBytes().length;  //바이트 형식으로 인코딩
    			len += s2.length();
    			
    			System.out.println((idx +1) + "번째문자 부터 일치합니다. ");
    			System.out.println("텍스트 : "+ s1);
    			System.out.printf(String.format("패턴 : %%%ds\n" , len),s2);
    		}
    	}
    }
}