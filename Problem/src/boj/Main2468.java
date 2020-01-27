package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2468 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static int N;
	static int map[][];
	static int ans = 1;
	static boolean is_visit[][];
	static Queue<dot> q;
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int min = 100, max = 1;
		
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		for(int cnt=min;cnt<max;cnt++) {
			is_visit = new boolean[N][N];
			int count = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(is_visit[i][j] || map[i][j] <= cnt) continue;
					count++;
					q = new LinkedList<dot>();
					q.add(new dot(j, i));
					is_visit[i][j] = true;
					while(!q.isEmpty()) {
						int x = q.peek().x;
						int y = q.poll().y;
						for(int d=0;d<4;d++) {
							int xx = x+dx[d];
							int yy = y+dy[d];
							if(is_map(xx, yy) && !is_visit[yy][xx] && map[yy][xx] > cnt) {
								q.add(new dot(xx, yy));
								is_visit[yy][xx] = true;
							}
						}
					}
				}
			}
			ans = Math.max(ans, count);
			
		}
		System.out.println(ans);
	}
	static boolean is_map(int x, int y) {
		if(x < 0 || y < 0 || x>=N || y>=N) return false;
		return true;
	}
}
