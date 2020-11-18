package sibal;

import java.util.*;
class Solution {

	static int bfMatch(String txt, String pat) {
	int pt=0; //Ŀ�� ��ġ
	int pp=0; //Ŀ�� ��ġ
	
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
    	
    	System.out.println("�ؽ�Ʈ: ");
    	String s1 =sc.next();
    	
    	System.out.println("����: ");
    	String s2 =sc.next();
    	
    	int idx = bfMatch(s1,s2);
    	
    	if(idx ==-1) { //if failed to success
    		System.out.println("�ؽ�Ʈ�� �������� �ʽ��ϴ�.");
    	}else {
    		int len =0;
    		for(int i=0; i<idx; i++) {
    			len +=s1.substring(i,i+1).getBytes().length;  //����Ʈ �������� ���ڵ�
    			len += s2.length();
    			
    			System.out.println((idx +1) + "��°���� ���� ��ġ�մϴ�. ");
    			System.out.println("�ؽ�Ʈ : "+ s1);
    			System.out.printf(String.format("���� : %%%ds\n" , len),s2);
    		}
    	}
    }
}