package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17836 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static int N, M, T;
	static class pair{
		int x;
		int y;
		int t;
		boolean g;
		public pair(int x, int y, int t, boolean g) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
			this.g = g;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean is_visit[][][] = new boolean[N][M][2];
		
		int time = 1;
		boolean is_end = false;
		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(0, 0, 0, false));
		end:while(!q.isEmpty()) {
			if(time > T) break;
			int size = q.size();
			for(int s=0;s<size;s++) {
				pair tmp = q.poll();
				for(int i=0;i<4;i++) {
					int xx = tmp.x+dx[i];
					int yy = tmp.y+dy[i];
					if(tmp.g) {
						if(is_map(xx, yy) && !is_visit[yy][xx][1]) {						
							if(xx == M-1 && yy == N-1) {
								is_end = true;
								break end;
							}
							is_visit[yy][xx][1] = true;
							q.add(new pair(xx, yy, tmp.t+1, tmp.g));						
						}
					}else {
						if(is_map(xx, yy) && !is_visit[yy][xx][0]) {						
							if(xx == M-1 && yy == N-1) {
								is_end = true;
								break end;
							}
							if(map[yy][xx] == 0) {
								is_visit[yy][xx][0] = true;
								q.add(new pair(xx, yy, tmp.t+1, tmp.g));								
							}else if(map[yy][xx] == 2) {
								is_visit[yy][xx][1] = true;
								q.add(new pair(xx, yy, tmp.t+1, true));
							}
						
						}
					}
					
				}
			}
			time++;
			
		}
		if(is_end) System.out.println(time);
		else System.out.println("Fail");
		
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
	
	
}
