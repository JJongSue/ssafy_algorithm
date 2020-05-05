package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11052 {
	static int arr[], dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = arr[1];
		System.out.println(get(N));
	}
	
	static int get(int now) {
		if(dp[now] != 0) return dp[now];
		dp[now] = arr[now];
		for(int i=now-1;i>=now/2;i--) {
			dp[now] = Math.max(dp[now], get(i) + get(now - i));
		}
		
		return dp[now];
	}
}
