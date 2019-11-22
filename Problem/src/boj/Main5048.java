package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5048 {	
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
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
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][M];
		boolean is_visit[][] = new boolean[N][M];		
		Queue<pair> q = new LinkedList<pair>();
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				if(map[i][j] == 'P') {		
					boolean ip=true;
					for(int k=0;k<4;k++) {
						if(map[i+dy[k]][j+dx[k]] == 'T') {
							ip=false;
							break;
						}
					}
					if(ip) {						
						is_visit[i][j] = true;
						q.add(new pair(j,i));
					}
				}
			}			
		}
		int cnt = 0;
		int max = 0;
		while(!q.isEmpty()) {
			pair tmp = q.poll();
			for(int i=0;i<4;i++) {
				int xx = tmp.x+dx[i];
				int yy = tmp.y+dy[i];
				if(!is_visit[yy][xx] && map[yy][xx] == '.') {
					is_visit[yy][xx] = true;
					boolean is_input = true;
					for(int j=0;j<4;j++) {
						if(map[yy+dy[j]][xx+dx[j]] == 'T') is_input=false;						
					}
					if(is_input) q.add(new pair(xx,yy));
				}else if(!is_visit[yy][xx] && map[yy][xx] == 'G') {					
					is_visit[yy][xx] = true;
					cnt++;					
					boolean is_input = true;
					for(int j=0;j<4;j++) {
						if(map[yy+dy[j]][xx+dx[j]] == 'T') is_input=false;						
					}
					if(is_input) q.add(new pair(xx,yy));					
				}
				
			}
		}
		System.out.println(cnt);
		
		
		
		
		
	}
}
