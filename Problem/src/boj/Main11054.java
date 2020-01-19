package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11054 {
	static int A[], dp[], dp2[], arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = new int[N];
		dp = new int[1001];
		dp2 = new int[1001];
		arr = new int[N];
		int ans = 0;
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(st.nextToken());
			A[i] = input;
			int max = dp[input];
			if(dp[input] == 0) {
				dp[input] = 1;
				max = 1;
			}
			for(int j=1;j<input;j++) {
				dp[input] = Math.max(dp[input], dp[j]+1);
			}
			arr[i] = dp[input];
		}
		for(int i=N-1;i>=0;i--) {
			int input = A[i];
			int max = dp2[input];
			if(dp2[input] == 0) {
				dp2[input] = 1;
				max = 1;
			}
			for(int j=1;j<input;j++) {
				dp2[input] = Math.max(dp2[input], dp2[j]+1);
			}
			arr[i] += dp2[input];
			ans = Math.max(ans, arr[i]);
		}
		
		
		System.out.println(ans-1);
	}
}
