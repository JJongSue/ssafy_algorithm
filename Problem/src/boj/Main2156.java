package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2156 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int dp[][] = new int[N][3];
		dp[0][0] = arr[0];
		dp[0][1] = arr[0];
		for(int i=1;i<N;i++) {
			dp[i][0] = dp[i-1][1]+arr[i];
			dp[i][1] = dp[i-1][2]+arr[i];
			int max = Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][2] = Math.max(max, dp[i-1][2]);
		}
		int max = Math.max(dp[N-1][0], dp[N-1][1]);
		max = Math.max(max, dp[N-1][2]);
		System.out.println(max);
	}
}
