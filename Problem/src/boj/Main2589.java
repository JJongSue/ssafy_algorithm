package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589 {
	static final int dx[] = {0,-1,1,0};
	static final int dy[] = {-1,0,0,1};
	static int N, M;
	static char [][]map;
	static boolean [][] is_visit;
	static int ans;
	static Queue<pair> q;
	
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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		ans = -1;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 'L') {
					is_visit = new boolean[N][M];
					q = new LinkedList<pair>();
					q.add(new pair(j,i));
					is_visit[i][j]=true;;
					bfs();
				}
				
			}
		}
		System.out.println(ans);
		
	}
	static void bfs() {
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				pair tmp = q.poll();
				for(int i=0;i<4;i++) {
					int xx = tmp.x+dx[i];
					int yy = tmp.y+dy[i];
					if(is_map(xx, yy) && map[yy][xx] == 'L' && !is_visit[yy][xx]) {
						is_visit[yy][xx] = true;
						q.add(new pair(xx, yy));
					}
				}
			}
			cnt++;
		}
		if(ans < cnt-1) ans =cnt-1;
		
		
		
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
}
