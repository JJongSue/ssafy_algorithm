package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9328 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static int N, M;
	
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			char map[][] = new char[N][M];
			for(int i=0;i<N;i++) {
				map[i] = br.readLine().toCharArray();
			}
			String KeySet = br.readLine();
			int key = 0;
			if(KeySet.charAt(0) != '0') {
				for(int i=0;i<KeySet.length();i++) {					
					key = key|(1<<KeySet.charAt(i)-'a');
				}
			}
			int cnt = 0;
			boolean is_visit[][] = new boolean[N][M];
			Queue<pair> q = new LinkedList<pair>();
			Queue<pair> tmpq = new LinkedList<pair>();
			for(int i=0;i<N;i++) {
				if(map[i][0] == '.' ) {
					q.add(new pair(0, i));
					is_visit[i][0]=true;
				}else if(map[i][0] >= 'a' && map[i][0]<='z') {
					q.add(new pair(0, i));
					key = key|(1<<(map[i][0]-'a'));
					is_visit[i][0]=true;
				}else if(map[i][0] >= 'A' && map[i][0] <='Z') {
					is_visit[i][0]=true;
					if( (key & (1<<(map[i][0]-'A'))) !=0 ) {
						q.add(new pair(0, i));
					}else {
						tmpq.add(new pair(0, i));
					}
				}else if(map[i][0] == '$') {
					map[i][0] = '.';
					is_visit[i][0] = true;
					cnt++;
					q.add(new pair(0, i));
				}
				
				if(map[i][M-1] == '.' ) {
					q.add(new pair(M-1, i));
					is_visit[i][M-1] =  true;
				}else if(map[i][M-1] >= 'a' && map[i][M-1]<='z') {
					q.add(new pair(M-1, i));
					key = key|(1<<(map[i][M-1]-'a'));
					is_visit[i][M-1]=true;
				}else if(map[i][M-1] >= 'A' && map[i][M-1] <='Z') {
					is_visit[i][M-1]=true;
					if( (key & (1<<(map[i][M-1]-'A'))) !=0 ) {
						q.add(new pair(M-1, i));
					}else {
						tmpq.add(new pair(M-1, i));
					}
				
				}else if(map[i][M-1] == '$') {
					q.add(new pair(M-1, i));
					is_visit[i][M-1] =  true;
					map[i][M-1] = '.';
					cnt++;
				}
			}
			for(int i=1;i<M-1;i++) {
				if(map[0][i] == '.' ) {
					q.add(new pair(i, 0));
					is_visit[0][i]=true;
				}else if(map[0][i] >= 'a' && map[0][i]<='z') {
					q.add(new pair(i, 0));
					key = key|(1<<(map[0][i]-'a'));
					is_visit[0][i]=true;
				}else if(map[0][i] >= 'A' && map[0][i] <='Z') {
					is_visit[0][i]=true;
					if( (key & (1<<(map[0][i]-'A'))) !=0 ) {
						q.add(new pair(i, 0));
					}else {
						tmpq.add(new pair(i, 0));
					}
				}else if(map[0][i] == '$') {
					map[0][i] = '.';
					is_visit[0][i] = true;
					q.add(new pair(i, 0));
					cnt++;
				}
				
				if(map[N-1][i] == '.' ) {
					q.add(new pair(i, N-1));
					is_visit[N-1][i] =  true;
				}else if(map[N-1][i] >= 'a' && map[N-1][i]<='z') {
					q.add(new pair(i, N-1));
					key = key|(1<<(map[N-1][i]-'a'));
					is_visit[N-1][i]=true;
				}else if(map[N-1][i] >= 'A' && map[N-1][i] <='Z') {
					is_visit[N-1][i]=true;
					if( (key & (1<<(map[N-1][i]-'A'))) !=0 ) {
						q.add(new pair(i, N-1));
					}else {
						tmpq.add(new pair(i, N-1));
					}
				
				}else if(map[N-1][i] == '$') {
					q.add(new pair(i, N-1));
					is_visit[i][N-1] =  true;
					map[N-1][i] = '.';
					cnt++;
				}
			}
			int size = tmpq.size();
			for(int s=0;s<size;s++) {
				pair tmp = tmpq.poll();
				if( (key & (1<<(map[tmp.y][tmp.x]-'A'))) !=0 ) {
					q.add(tmp);
				}else {
					tmpq.add(tmp);
				}
				
				
			}
			while(!q.isEmpty()) {
				size = q.size();
				for(int s=0;s<size;s++) {
					pair tmp = q.poll();
					for(int i=0;i<4;i++) {
						int xx = tmp.x+dx[i];
						int yy = tmp.y+dy[i];
						if(is_map(xx, yy) && !is_visit[yy][xx]) {
							is_visit[yy][xx] = true;
							if(map[yy][xx] == '.') {
								q.add(new pair(xx, yy));
							}else if(map[yy][xx] >= 'a' && map[yy][xx]<='z') {
								q.add(new pair(xx, yy));
								key = key|(1<<(map[yy][xx]-'a'));
							}else if(map[yy][xx] >='A' && map[yy][xx] <= 'Z') {
								if( (key & (1<<(map[yy][xx]-'A'))) !=0 ) {
									q.add(new pair(xx, yy));
								}else {
									tmpq.add(new pair(xx, yy));
								}
							}else if(map[yy][xx] == '$') {
								q.add(new pair(xx, yy));
								cnt++;
								map[yy][xx] = '.';
							}
						}
					}				
				}
				size = tmpq.size();
				for(int s=0;s<size;s++) {
					pair tmp = tmpq.poll();
					if( (key & (1<<(map[tmp.y][tmp.x]-'A'))) !=0 ) {
						q.add(tmp);
					}else {
						tmpq.add(tmp);
					}
					
					
				}
				
				
			}
			System.out.println(cnt);
			
			
			
			
			
			
			
			
			
			
			
		}
	}
	
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
