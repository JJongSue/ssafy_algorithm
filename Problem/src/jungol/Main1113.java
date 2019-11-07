package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1113 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static int map[][];
	static int dis[][][];
	static int N, M;
	
	static class pair{
		int x;
		int y;
		int r;
		public pair(int x, int y, int r) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int dey = Integer.parseInt(st.nextToken());
		int dex = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dis = new int[N][M][4];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<pair> q = new LinkedList<pair>();
		int xx=0;
		int yy=0;
		q.add(new pair(0,0,1));
		q.add(new pair(0,0,2));
		while(true) {
			xx+=dx[1];
			yy+=dy[1];
			if(is_map(xx, yy) && map[yy][xx] == 1) {
				q.add(new pair(xx,yy,1));
				dis[yy][xx][1]=1;
			}
			else break;
		}
		xx=0;
		yy=0;
		while(true) {
			xx+=dx[2];
			yy+=dy[2];
			if(is_map(xx, yy) && map[yy][xx] == 1) {
				q.add(new pair(xx,yy,2));
				dis[yy][xx][2]=1;
			}
			else break;
		}
		
		dis[0][0][1] = 1;
		dis[0][0][2] = 1;
		int rotate = 2;
		int ans = 987654321;
		end:while(!q.isEmpty()) {
			for(int i=0;i<4;i++) {
				if(dis[dey][dex][i] != 0) {
					ans = dis[dey][dex][i];
					//System.out.println("and"+dis[dey][dex][i]);
					break end;
				}
			}
			int size = q.size();
			for(int s=0;s<size;s++) {
				pair tmp = q.poll();
				int xxx = tmp.x;
				int yyy = tmp.y;
				//System.out.println(xxx+" "+yyy+" "+tmp.r);
				int rr = tmp.r;
				for(int i=0;i<4;i++) {
					if(rr == i) continue;
					//System.out.println(yy+" "+xx+" "+i);
					//if(dis[yyy][xxx][i] != 0) continue;
					dis[yyy][xxx][i] = rotate;
					xx= xxx;
					yy= yyy;
					while(true) {
						xx += dx[i];
						yy += dy[i];
						if(is_map(xx, yy) && map[yy][xx] == 1 && dis[yy][xx][i] == 0) {
							q.add(new pair(xx,yy,i));
							dis[yy][xx][rr] = rotate;
						}else break;
					}
					
				}
			}
			rotate++;
		}
		System.out.println(ans-1);
		
		
	}
	
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
