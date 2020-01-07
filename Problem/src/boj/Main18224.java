package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18224 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static int N, M;
	static int visit[][], map[][];
	static boolean is_visit[][];
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static Queue<pair> q = new LinkedList<pair>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+2][N+2];
		visit = new int[N][N];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//visit[i][j] = 987654321;
			}
		}
		
		q.add(new pair(1, 1));
		int day = 1;
		int ans = -1;
		end:while(!q.isEmpty()) {
			if(day > 2500000) break;
			int size = q.size();
			is_visit = new boolean[N+2][N+2];
			for(int s=0;s<size;s++) {
				int x = q.peek().x;
				int y = q.poll().y;
				//System.out.println(x + " " + y);
				for(int i=0;i<4;i++) {
					int xx = x+dx[i];
					int yy = y+dy[i];
					if(xx == N && yy == N) {
						ans = day;
						break end;
					}
					if(!is_map(xx, yy)) continue;
					if(map[yy][xx] == 0) {
						if(is_visit[yy][xx]) continue;
						q.add(new pair(xx, yy));
						is_visit[yy][xx] = true;
					}else if( (day/M)%2 == 0 ){
						while(map[yy][xx] != 1) {
							xx += dx[i];
							yy += dy[i];
						}
						if(!is_map(xx, yy)) continue;
						if(is_visit[yy][xx]) continue;
						q.add(new pair(xx, yy));
						is_visit[yy][xx] = true;
					}
				}
			}
			day++;
			
		}
		if(ans == -1) {
			System.out.println(-1);
		}else {
			if((ans/M)%2 == 0) {
				System.out.println((ans/M)/2 + " sun");
			}else {
				System.out.println((ans/M)/2 + " moon");
			}
			
		}
	
		
	}
	static boolean is_map(int x, int y) {
		if(x <= 0 || y <= 0 || x >= N+1 || y >= N+1) return false;
		return true;
	}
}
