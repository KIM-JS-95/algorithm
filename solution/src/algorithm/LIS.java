package algorithm;

import java.util.*;
//최장공통수열
public class LIS {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int tc = sc.nextInt();
			
			for(int t = 1; t <= tc; t++) {
				int n = sc.nextInt();
				int[] a = new int[n];
				int[] dp = new int[n];
				int max = 0;
				for(int i = 0; i < n; i++) {
					a[i] = sc.nextInt();
				}
				
				dp[0] = 1;
				
				for(int i = 1; i < n; i++) {
					dp[i] = 1;
					for(int j = 0; j < i; j++) {
						if(a[i] >= a[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
					}
					max = Math.max(max,dp[i]);
				}
				System.out.println("#" + t + " " + max);
			}
		}
}
