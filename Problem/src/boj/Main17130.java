package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17130 {
	static final int dx[] = {1,1,1};
	static final int dy[] = {-1,0,1};
	static int nummap[][];
	static boolean is_visit[][];
	static class rabit{
		int x;
		int y;
		int cnt;
		public rabit(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int ans = -1;
	static Queue<rabit> q = new LinkedList<rabit>();
	static int N, M;
	static char map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		nummap = new int[N][M];
		is_visit = new boolean[N][M];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			
			for(int j=0;j<M;j++) {
				nummap[i][j] = -1;
				if(map[i][j] == 'R') {
					q.add(new rabit(j, i, 0));
					nummap[i][j] = 0;
				}
			}
		}
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				int x = q.peek().x;
				int y = q.peek().y;
				int cnt = q.poll().cnt;
				if(nummap[y][x] != cnt) continue;
				
				for(int i=0;i<3;i++) {
					int xx = x+dx[i];
					int yy = y+dy[i];
					if(is_map(xx, yy) ) {
						if(map[yy][xx] == 'O' && (nummap[yy][xx] < cnt ) ) {
							ans = Math.max(ans, cnt);
							nummap[yy][xx] = cnt;
							is_visit[yy][xx] = true;
							if(xx != M-1) q.add(new rabit(xx, yy, cnt));
						}else if(map[yy][xx] == 'C' && (nummap[yy][xx] < cnt+1 ) ) {
							nummap[yy][xx] = cnt+1;
							is_visit[yy][xx] = true;
							if(xx != M-1) q.add(new rabit(xx, yy, cnt+1));
						}else if(map[yy][xx] == '.' && (nummap[yy][xx] < cnt ) ) {
							nummap[yy][xx] = cnt;
							is_visit[yy][xx] = true;
							if(xx != M-1) q.add(new rabit(xx, yy, cnt));
						}
					}
				}
			}
			
		}
		System.out.println(ans);
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
}
