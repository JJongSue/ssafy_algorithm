package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4485 {
	static final int[] dx = {0,-1,1,0};
	static final int[] dy = {-1,0,0,1};
	static int N;
	static long [][] dp;
	static int [][]map;
	static boolean [][]is_visit;
	static PriorityQueue<dot> pq;
	static class dot implements Comparable<dot>{
		int x;
		int y;
		long dis;
		public dot(int x, int y, long dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
		@Override
		public int compareTo(dot o) {
			// TODO Auto-generated method stub
			return Long.compare(this.dis,o.dis);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();		
		long cnt = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			dp = new long[N][N];
			map = new int[N][N];
			is_visit = new boolean[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) Arrays.fill(dp[i], Long.MAX_VALUE);
			dp[0][0] = map[0][0];
			pq = new PriorityQueue<>();
			pq.add(new dot(0, 0, 0));
			while(!pq.isEmpty()) {
				dot tmp = pq.poll();			
				int x = tmp.x;
				int y = tmp.y;
				//if(dp[N-1][N-1] != Long.MAX_VALUE) break;
				if(dp[y][x] < tmp.dis) continue;
				for(int i=0;i<4;i++) {
					if(!is_map(x+dx[i], y+dy[i])) continue;
					if(tmp.dis+map[y][x] < dp[y+dy[i]][x+dx[i]]) {
						pq.add(new dot(x+dx[i], y+dy[i], tmp.dis+map[y][x]));
						dp[y+dy[i]][x+dx[i]] = tmp.dis+map[y][x];
					}							
				}
			}
			sb.append("Problem ").append(cnt).append(": ").append((dp[N-1][N-1]+map[N-1][N-1])).append("\n");
			cnt++;
			//System.out.println("Problem "+cnt+dp[N-1][N-1]+map[N-1][N-1]);
		}System.out.println(sb);
		
	}
	static boolean is_map(int x, int y) {
		if( x < 0 || y < 0 || x >= N || y >= N) return false;
		return true;
	}
}
