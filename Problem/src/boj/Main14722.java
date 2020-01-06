package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main14722 {
	static int map[][];
	static int dp[][][];
	static int N;
	static int ans = 0;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N][4];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int now = map[i][j];
				if(now == 0) {
					dp[i][j][0] = 1;
				}
				if(i!=0) {
					dp[i][j][now] = Math.max(dp[i][j][now], dp[i-1][j][(now+2)%3]+1);
					//dp[i][j][now] = Math.max(dp[i][j][now], dp[i-1][j][3]);
					dp[i][j][3] = Math.max(dp[i][j][3], dp[i-1][j][3]);
				}
				if(j!=0) {
					dp[i][j][now] = Math.max(dp[i][j][now], dp[i][j-1][(now+2)%3]+1);
					//dp[i][j][now] = Math.max(dp[i][j][now], dp[i][j-1][3]);
					dp[i][j][3] = Math.max(dp[i][j][3], dp[i][j-1][3]);
				}
				dp[i][j][3] = Math.max(dp[i][j][now], dp[i][j][3]);
				//dp[i][j][now] = dp[i][j][3];
				ans = Math.max(ans, dp[i][j][now]);
				
			}
		}
		System.out.println(ans);
	
		
	}
	
	
}
