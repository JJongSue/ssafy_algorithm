package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1965_2 {
	static int A[], dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = new int[N];
		dp = new int[1001];
		int ans = 0;
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(st.nextToken());
			int max = dp[input];
			if(dp[input] == 0) {
				dp[input] = 1;
				max = 1;
			}
			for(int j=1;j<input;j++) {
				dp[input] = Math.max(dp[input], dp[j]+1);
			}
			
			ans = Math.max(dp[input], ans);
		}
		
		System.out.println(ans);
	}
}
