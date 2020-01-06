package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17485 {
	static final int dx[] = {1,0,-1};
	static int map[][];
	static int dp[][][];
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M][3];
		
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<M;j++) {
			map[0][j] = Integer.parseInt(st.nextToken());
			dp[0][j][0] = map[0][j];
			dp[0][j][1] = map[0][j];
			dp[0][j][2] = map[0][j];
		}
		long max = 987654321;
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				for(int k=0;k<3;k++) {
					dp[i][j][k] = 987654321;
				}
				for(int k=0;k<3;k++) {
					for(int l=0;l<3;l++) {
						if(k == l) continue;
						if(j+dx[k]>=0 && j+dx[k]<=M-1) {
							dp[i][j][k] = Math.min(dp[i-1][j+dx[k]][l], dp[i][j][k]);
						}
					}
					dp[i][j][k] += map[i][j];
					//max = Math.min(dp[i][j][k], max);
				}
			}
		}
		for(int j=0;j<M;j++) {
			for(int k=0;k<3;k++) {
				max = Math.min(max, dp[N-1][j][k]);
			}
		}
		System.out.println(max);
	}
}
