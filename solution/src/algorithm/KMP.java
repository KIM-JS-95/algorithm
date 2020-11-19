//This algorithm have good efficiency than Brute-Force algorithm 
package algorithm;
import java.util.*;
public class KMP {
	static int kmpMatch(String pat, String txt) {
		int pt =1;
		int pp=0;
		int[] skip = new int[pat.length()+1];
		
		skip[pt]=0;
		while( pt != pat.length()) {
			if(pat.charAt(pt) == pat.charAt(pp)){
				skip[++pt] = ++pp;
			}else if(pp==0) {
				skip[++pt] = ++pp;
			}else {
				pp = skip[pp];
			}
		}
			pt=pp=0;
			while(pt != txt.length() && pp != pat.length()) {
				if(txt.charAt(pt) == pat.charAt(pp)) {
					pt++;
					pp++;
				}else if(pp==0) {
				pt++;
				}
				else {
					pp = skip[pp];
				}
			}
		if(pp==pat.length())
			return pt-pp;
			return -1;
	}
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1= sc.next();
		String s2= sc.next();
		int answer=kmpMatch(s1,s2);
		
		System.out.println(answer);
		
	}
}
