package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1445 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	
	static int N, M;
	static char map[][];
	static boolean is_visit[][][];
	static boolean is_plus [][];
	static Queue<pair> q = new LinkedList<pair>();
	
	static class pair{
		int x; 
		int y;
		int cnt;
		int cnt2;
		public pair(int x, int y, int cnt, int cnt2) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.cnt2 = cnt2;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		is_visit = new boolean[N][M][N*M];
		is_plus = new boolean[N][M];
		pair S=new pair(0,0,0,0), F;
		int ans1 = N*M, ans2 = N*M;
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				if(map[i][j] == 'S') S = new pair(j, i, 0,0);
				else if(map[i][j] == 'F') F = new pair(j, i, 0,0);
				else if(map[i][j] == 'g') {
					for(int k=0;k<4;k++) {
						if(is_ok(j+dx[k], i+dy[k])) {
							is_plus[i+dy[k]][j+dx[k]] = true;
						}
					}
				}
			}
		}
		q.add(S);
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int cnt = q.peek().cnt;
			int cnt2 = q.poll().cnt2;
			if(cnt > ans1) continue;
			if(cnt == ans1 && cnt2 > ans2) continue;
			for(int i=0;i<4;i++) {
				int xx = x+dx[i];
				int yy = y+dy[i];
				if(is_ok(xx, yy)) {
					if(map[yy][xx]=='F') {
						ans1 = cnt;
						ans2 = cnt2;
						break;
					}else if(map[yy][xx] == '.') {
						if(is_plus[yy][xx] && !is_visit[yy][xx][cnt+1]) {
							is_visit[yy][xx][cnt+1] = true;
							q.add(new pair(xx,yy,cnt+1));
						}else if(!is_plus[yy][xx] && !is_visit[yy][xx][cnt]) {
							is_visit[yy][xx][cnt] = true;
							q.add(new pair(xx, yy, cnt));
						}
					}
				}
			}
			
		}
		System.out.println(ans);
		
		
		
	}
	static boolean is_ok(int x, int y) {
		if(x < 0 || y < 0 || x>=M || y>=N) return false;
		return true;
	}
	
}
