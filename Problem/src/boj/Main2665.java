package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2665 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		int dp[][] = new int[N+1][N+1];
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = (int)(tmp.charAt(j)-'0');
				if(map[i][j] == 0) dp[i][j] = 1;
			}
		}
		for(int i=N-1;i>=0;i--) {
			for(int j=N-1;j>=0;j--) {
				if(j == N-1) {
					dp[i][j] = dp[i][j] + dp[i+1][j];
				}else if(i == N-1) {
					dp[i][j] = dp[i][j] + dp[i][j+1];
				}
				else dp[i][j] = dp[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
			}
		}
		System.out.println(dp[0][0]);
	}
}
