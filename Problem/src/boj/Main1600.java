package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1600 {
	static final int dx[] = {2,2,1,-1,-2,-2,-1,1};
	static final int dy[] = {-1,1,2,2,1,-1,-2,-2};
	static final int ddy[] = {-1,0,0,1};
	static final int ddx[] = {0,-1,1,0};
	static int K, N, M;
	static int map[][];
	static int dp[][][];
	
	static class mal{
		int x;
		int y;
		int cnt;
		public mal() {
			super();
			// TODO Auto-generated constructor stub
		}
		public mal(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M][K+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<mal> q = new LinkedList<mal>();
		q.add(new mal(0,0,0));
		int time = 1;
		dp[0][0][0] = 1;
		int ans = -1;
		while(!q.isEmpty()) {
			for(int find=0;find<=K;find++) {
				if(dp[N-1][M-1][find] != 0 && ans != -1 && ans > dp[N-1][M-1][find] ) {
					ans = dp[N-1][M-1][find];
					//break end;
				}
				if(dp[N-1][M-1][find] != 0 && ans == -1) ans = dp[N-1][M-1][find];
			}			
			int size = q.size();
			for(int s=0;s<size;s++) {
				mal tmp = q.poll();
				for(int i=0;i<4;i++) {
					int xx = tmp.x+ddx[i];
					int yy = tmp.y+ddy[i];
					if(is_map(xx, yy) && map[yy][xx] == 0 && dp[yy][xx][tmp.cnt] == 0) {
						dp[yy][xx][tmp.cnt] = time;
						q.add(new mal(xx, yy, tmp.cnt));						
					}
				}				
				for(int i=0;i<8;i++) {
					int xx = tmp.x+dx[i];
					int yy = tmp.y+dy[i];
					if(is_map(xx, yy) &&  map[yy][xx] == 0 && tmp.cnt+1 <= K && dp[yy][xx][tmp.cnt+1]==0) {
						dp[yy][xx][tmp.cnt+1] = time;
						q.add(new mal(xx,yy,tmp.cnt+1));
					}
				}
			}
			
			
			
			time++;
		}
		System.out.println(ans);
		
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>= M || y>=N) return false;
		return true;
	}
	
	static boolean is_stone(int x, int y, int r) {
		if(r == 0) {
			if(map[y][x+1] == 1 ) return false;			
		}else if(r == 1) {
			if(map[y][x+1] == 1 ) return false;
		}else if(r == 2) {
			if(map[y+1][x] == 1 ) return false;
		}else if(r == 3) {
			if(map[y+1][x] == 1 ) return false;
		}else if(r == 4) {
			if(map[y][x-1] == 1 ) return false;
		}else if(r == 5) {
			if(map[y][x-1] == 1 ) return false;
		}else if(r == 6) {
			if(map[y-1][x] == 1 ) return false;
		}else if(r == 7) {
			if(map[y-1][x] == 1 ) return false;
		}
		return true;
	}
}
