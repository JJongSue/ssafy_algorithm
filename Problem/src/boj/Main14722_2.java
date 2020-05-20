package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main14722_2 {
	static int map[][];
	static int dp[][];
	static int N;
	static int ans = 0;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=N;i++) {
			
			for(int j=1;j<=N;j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if(dp[i-1][j] % 3 == map[i][j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+1);
				}
				if(dp[i][j-1]%3 == map[i][j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j-1]+1);
				}
				//System.out.print(dp[i][j]+" ");
			}//System.out.println();
		}
		System.out.println(dp[N][N]);
	
		
	}
	
	
}
