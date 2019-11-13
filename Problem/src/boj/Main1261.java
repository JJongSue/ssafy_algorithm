package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1261 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static int map[][];
	static int dp[][];
	static int N, M;
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
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = tmp.charAt(j)-'0';
				dp[i][j] = 987654321;
				//if(map[i][j] == 1) dp[i][j] = 1;
			}
		}
		
		dp[N-1][M-1] = 0;
		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(M-1, N-1));
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			//System.out.println(x+" "+y);
			for(int i=0;i<4;i++) {
				int xx= x+dx[i];
				int yy = y+dy[i];
				if(is_map(xx, yy) && dp[y][x]+map[yy][xx] < dp[yy][xx]) {
					dp[yy][xx] = dp[y][x]+map[yy][xx];
					q.add(new pair(xx, yy));
				}
			}
		}
		System.out.println(dp[0][0]);
		
		
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
}
