package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17953 {
	static int dp[][], map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<M;i++) dp[i][0] = map[i][0];
		for(int i=1;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int k=0;k<M;k++) {
					if(k == j) {
						dp[j][i] = Math.max(dp[j][i],dp[k][i-1]+map[j][i]/2 );
					}else {
						dp[j][i] = Math.max(dp[j][i],dp[k][i-1]+map[j][i] );
					}
				}
			}
		}
		int max = 0;
		for(int i=0;i<M;i++) max = Math.max(max, dp[i][N-1]);
		System.out.println(max);
		
		
	}
}
