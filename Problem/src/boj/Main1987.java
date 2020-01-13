package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1987 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static boolean is_visit[][], is_alpa[] = new boolean[26];
	static char map[][];
	static int N, M, ans=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		is_visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		dfs(0,0,1);
		System.out.println(ans);
		
	}
	static void dfs(int x, int y, int now) {
		ans = Math.max(ans, now);
		is_visit[y][x]=true;
		int ch = map[y][x]-'A';
		is_alpa[ch] = true;
		for(int i=0;i<4;i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(is_map(xx, yy) && !is_visit[yy][xx] && !is_alpa[map[yy][xx]-'A']) {
				dfs(xx,yy,now+1);
			}
		}
		is_visit[y][x]=false;
		is_alpa[ch] = false;
	}
	
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
}
