package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1194 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	
	static int N, M;
	
	static class pair{
		int x;
		int y;
		int key;
		
		public pair(int x, int y, int key) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char map[][] = new char[N][M];
		Queue<pair> q = new LinkedList<pair>();
		boolean is_visit[][][] = new boolean[N][M][(1<<6)];
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				if(map[i][j] == '0') {
					q.add(new pair(j, i, 0));
					map[i][j] = '.';
				}
			}
		}
		
		int ans = -1;
		int time = 1;
		end: while(!q.isEmpty()) {
			int size = q.size();
			for(int qs=0;qs<size;qs++) {
				int x = q.peek().x;
				int y = q.peek().y;
				int key = q.poll().key;
				//System.out.println(x+" "+y);
				
				
				for(int s=0;s<4;s++) {
					int xx = x+dx[s];
					int yy = y+dy[s];
					if(is_map(xx, yy) && map[yy][xx] == '1' ) {
						ans=time;
						break end;
					}else if(is_map(xx, yy) && !is_visit[yy][xx][key] && map[yy][xx] == '.' ) {
						q.add(new pair(xx, yy, key));
						is_visit[yy][xx][key]=true;
					}else if(is_map(xx, yy) && !is_visit[yy][xx][key] && (map[yy][xx] >= 'a' && map[yy][xx] <= 'f') ) {
						is_visit[yy][xx][key] = true;
						int tmpkey = key|(1<<(map[yy][xx]-'a'));
						is_visit[yy][xx][tmpkey] = true;
						q.add(new pair(xx, yy, tmpkey));
					}else if(is_map(xx, yy) && !is_visit[yy][xx][key] && (map[yy][xx] >= 'A' && map[yy][xx] <= 'F') ) {
						if((1<<(map[yy][xx]-'A') & key) != 0) {
							q.add(new pair(xx, yy, key));
							is_visit[yy][xx][key]=true;
						}
					}
				}
				
			}
			time++;
			
		}
		System.out.println(ans);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
}
