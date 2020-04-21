package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9465 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			if(N == 1) {
				int a = Integer.parseInt(br.readLine());
				int b = Integer.parseInt(br.readLine());
				sb.append(Math.max(a,b)).append("\n");
				continue;
			}			
			int map[][] = new int[2][N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				map[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				map[1][i] = Integer.parseInt(st.nextToken());
			}
			if(N == 2) {
				sb.append(Math.max(map[0][0]+map[1][1],map[1][0]+map[0][1])).append("\n");
				continue;
			}
			int dp[][] = new int[2][N+1];
			dp[0][0] = map[0][0];
			dp[1][0] = map[1][0];
			dp[0][1] = map[1][0] + map[0][1];
			dp[1][1] = map[0][0] + map[1][1];
			for(int i=2;i<N;i++) {
				int max = Math.max(dp[1][i-1], dp[0][i-2]);
				dp[0][i] = Math.max(max, dp[1][i-2]) + map[0][i];
				max = Math.max(dp[0][i-1], dp[1][i-2]);
				dp[1][i] = Math.max(max, dp[0][i-2]) + map[1][i];
			}
			sb.append(Math.max(dp[0][N-1], dp[1][N-1])).append("\n");
			
		}
		System.out.println(sb);
	}
}
