package boj;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class Main9251 {
	static String A, B;
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine();
		B = br.readLine();
		
		dp = new int[A.length()+1][B.length()+1];
		for(int i=0;i<A.length();i++) {
			for(int j=0;j<B.length();j++) {
				if(A.charAt(i) == B.charAt(j)) {
					dp[i+1][j+1] = dp[i][j]+1;
				}else {
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}
		}
		int ans = 0;
		for(int i=0;i<=B.length();i++) {
			ans = Math.max(ans, dp[A.length()][i]);
		}
		
		System.out.println(ans);
		
	}
}
