package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2423 {
	//아래 대각, 위대각, 아래 왼대각
	static int dx[] = {1,1,-1};
	static int dy[] = {1,-1,1};
	
	static int N, M;
	static int dp[][];
	static char map[][];
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new char[N][M];
		dp = new int[N+1][M+1];
		for(int i=0;i<N+1;i++) {
			for(int j=0;j<M+1;j++) {
				dp[i][j] = 987654321;
			}
		}
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		dp[0][0] = 0;
		if(map[0][0] == '/') dp[1][1] = 1;
		else dp[1][1] = 0;
		
		
		
		
	}
}
