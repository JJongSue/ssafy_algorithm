package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2665 {
	static final int dx[] = {-1,0,0,1};
	static final int dy[] = {0,-1,1,0};
	
	static class pair{
		int x;
		int y;
		int t;
		public pair(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}
		
	}
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		int dp[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = (int)(tmp.charAt(j)-'0');
				//if(map[i][j] == 0) dp[i][j] = 1;
				dp[i][j] = 987654321;
			}
		}
		Queue<pair> q = new LinkedList<pair>();
		int time = 0;
		q.add(new pair(N-1,N-1, 0));
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int t = q.poll().t;
			for(int i=0;i<4;i++) {
				if(is_map(x+dx[i], y+dy[i]) ) {
					if(map[y+dy[i]][x+dx[i]] == 0 ) {
						if(dp[y+dy[i]][x+dx[i]] > t+1) {
							dp[y+dy[i]][x+dx[i]] = t+1;
							q.add(new pair(x+dx[i], y+dy[i], t+1));
						}
					}else {
						if(dp[y+dy[i]][x+dx[i]] > t) {
							dp[y+dy[i]][x+dx[i]] = t;
							q.add(new pair(x+dx[i], y+dy[i], t));
						}
					}
				}
			}
		}
		System.out.println(dp[0][0]);
	}
	
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=N) return false;
		return true;
	}
}
