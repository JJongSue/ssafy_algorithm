package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5456 {
	static final int dx[] = {-1,0,0,1};
	static final int dy[] = {0,-1,1,0};
	static int N;
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public pair() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][N];
		pair bear=new pair();
		pair des = new pair();
		Queue<pair> bq = new LinkedList<pair>();
		int bmap[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) bmap[i][j] = 987654321;
		}
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				if(map[i][j] == 'M') {
					bear = new pair(j,i);
				}else if(map[i][j] == 'H') {
					bq.add(new pair(j,i));
					bmap[i][j] = 1;
				}else if(map[i][j] == 'D') {
					des = new pair(j, i);
				}
			}
			
		}
		
		int time = 1;
		while(!bq.isEmpty()) {
			int size = bq.size();
			for(int s=0;s<size;s++) {
				pair tmp = bq.poll();
				for(int i=0;i<4;i++) {
					int xx = tmp.x+dx[i];
					int yy = tmp.y+dy[i];
					if(is_map(xx, yy) && (map[yy][xx] == 'G' || map[yy][xx] == 'M') && bmap[yy][xx]==987654321) {
						bmap[yy][xx]=time;
						bq.add(new pair(xx,yy));
					}
				}
			}
			time++;
		}
		/*for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(bmap[i][j] + " ");
				
			}System.out.println();
		}*/
		int maxtime = time;
		int l=0, r=bmap[bear.y][bear.x];
		int ans = -1;
		while(l<=r) {
			int mid = (l+r)/2;
			//System.out.println(mid);
			bq = new LinkedList<pair>();
			boolean is_visit[][]=new boolean[N][N];
			int nowtime = mid;
			time=1;
			//if(mid == 1) time=0;
			bq.add(bear);
			is_visit[bear.y][bear.x]=true;
			boolean is_ok = false;
			end:while(!bq.isEmpty()) {
				if(nowtime+time >= maxtime) break;
				//System.out.println(nowtime+time);
				for(int mv=0;mv<S;mv++) {
					
					int size = bq.size();
					for(int s=0;s<size;s++) {
						pair tmp = bq.poll();
						if(bmap[tmp.y][tmp.x]<nowtime+time) continue;
						//is_visit[tmp.y][tmp.x]=true; 
						/*if(tmp.x == des.x && tmp.y == des.y) {
							is_ok = true;
							break end;
						}*/
						for(int i=0;i<4;i++) {
							int xx = tmp.x+dx[i];
							int yy = tmp.y+dy[i];
							if(is_map(xx, yy) && (map[yy][xx] == 'G' || map[yy][xx] == 'D') && !is_visit[yy][xx] && bmap[yy][xx]>=nowtime+time) {
								if(xx == des.x && yy == des.y) {
									is_ok =true;
									break end;
								}
								//System.out.println(xx+" "+yy);
								is_visit[yy][xx] = true;
								bq.add(new pair(xx,yy));
							}
						}
					}
					
				}
				time++;
				
			}
			if(is_ok) {
				l=mid+1;
				ans = Math.max(ans, mid);
			}else {
				r=mid-1;
				/*if(ans != -1) {
				}else ans=mid;*/
			}
			
			
		}
		
		
		System.out.println(ans);
		
		
	}
	
	static boolean is_map(int x, int y) {
		if(x >= N || y>= N || x<0 || y<0) return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
