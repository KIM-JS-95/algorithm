package algorithm;

import java.util.*;

//최장공통부분수열은 동적계획법을 통해 해결할 것
public class LCS {
	public static void main(String[] arg) {
		 Scanner sc = new Scanner(System.in);
		
				String s1 = sc.next();
				String s2 = sc.next();
				String max;
				String min;
				int cnt = 0;
				
				if(s1.length() > s2.length()) {
					max = s1;
					min = s2;
				}
				else {
					max = s2;
					min = s1;
				}
				
				int[][] a = new int[min.length()][max.length()];
				
				if(max.charAt(0) == min.charAt(0)) a[0][0] = 1;
				else a[0][0] = 0;
				
				for(int i = 1; i < max.length(); i++) {
					if(max.charAt(i) == min.charAt(0)) {
						a[0][i] = a[0][i-1] + 1;
					}
					else {
						a[0][i] = a[0][i-1];
					}
				}
				
				for(int i = 1; i < min.length(); i++) {
					if(max.charAt(0) == min.charAt(i)) {
						a[i][0] = a[i-1][0] + 1;
					}
					else {
						a[i][0] = a[i-1][0];
					}
					for(int j = 1; j < max.length(); j++) {
						if(min.charAt(i) == max.charAt(j)){
							a[i][j] = Math.max(a[i-1][j], a[i][j-1]) + 1;
						}
						else {
							a[i][j] = Math.max(a[i-1][j], a[i][j-1]);
						}
						cnt = Math.max(a[i][j], cnt);
					}
				}
				System.out.println(cnt);
		}
	}