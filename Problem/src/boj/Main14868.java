package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14868 {
	static final int dx[] = {0,-1,1,0};	
	static final int dy[] = {-1,0,0,1};
	static int parents[];
	
	static int find_set(int x) {
		if( x== parents[x]) return x;
		return parents[x] = find_set(parents[x]);
	}
	static void union(int x, int y) {
		int px = find_set(x);
		int py = find_set(y);
		parents[py] = px;
	}
	
	static int N, K;
	static int map[][];
	static boolean is_visit[][];
	static ArrayList<pair> al;
	
	static class pair{
		int x;
		int y;
		public pair() {
			super();
			// TODO Auto-generated constructor stub
		}
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
		K = Integer.parseInt(st.nextToken());
		is_visit = new boolean[N][N];
		Queue<pair> q = new LinkedList<>();
		parents = new int[N*N];
		for(int i=0;i<N*N;i++) {
			parents[i] = i;
		}		
		al = new ArrayList<>();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int tmpx = Integer.parseInt(st.nextToken())-1;
			int tmpy = Integer.parseInt(st.nextToken())-1;
			al.add(new pair(tmpx, tmpy));
			q.add(new pair(tmpx, tmpy));
			is_visit[tmpy][tmpx] = true;
		}
		int time = 0;
		while(true) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				pair tmp = q.poll();
				int ptmp = find_set(tmp.y*N+tmp.x);
				for(int i=0;i<4;i++) {
					int xx = tmp.x+dx[i];
					int yy = tmp.y+dy[i];
					if(is_map(xx, yy) && is_visit[yy][xx]) {
						int fp = find_set(yy*N+xx);
						if(ptmp != fp) {
							union(ptmp, yy*N+xx);
						}
					}
				}
				q.add(tmp);
			}
			
			break;
		}
		
		while(!q.isEmpty()) {
			if(is_end()) {
				break;
			}
			int size = q.size();
			for(int s=0;s<size;s++) {
				pair tmp = q.poll();
				int ptmp = find_set(tmp.y*N+tmp.x);
				for(int i=0;i<4;i++) {
					int xx = tmp.x+dx[i];
					int yy = tmp.y+dy[i];
					if(is_map(xx, yy)) {
						if(!is_visit[yy][xx]) {
							q.add(new pair(xx,yy));
							parents[yy*N+xx] = ptmp;
							is_visit[yy][xx] = true;
						}else {
							int fp = find_set(yy*N+xx);
							if(ptmp != fp) {
								union(ptmp, yy*N+xx);
							}
							
						}
						for(int j=0;j<4;j++) {
							int xxx = xx+dx[j];
							int yyy = yy+dy[j];
							if(is_map(xxx, yyy) && is_visit[yyy][xxx]) {
								int fp = find_set(yyy*N+xxx);
								if(ptmp != fp) {
									union(ptmp, yyy*N+xxx);
								}
							}
							
						}
					}
				}
			}
			
			time++;
		}
		System.out.println(time);
		
		
	}
	
	static boolean is_map(int x, int y) {
		if(x < 0 || y <0 || x>= N || y>=N) return false;
		return true;
	}
	static boolean is_end() {
		int cnt = 0;
		for(pair tmp : al) {
			int dot = tmp.y*N+tmp.x;
			if(find_set(dot) == dot) cnt++;
			if(cnt == 2) return false;
		}
		return true;
	}
	
	
}
