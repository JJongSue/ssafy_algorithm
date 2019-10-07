package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main17472 {
	static int N, M;
	static int map[][];
	static boolean is_visit[][];
	static int[][] colormap;
	
	static class bridge implements Comparable<bridge>{
		int start;
		int end;
		int distance;
		public bridge(int start, int end, int distance) {
			super();
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
		@Override
		public int compareTo(bridge o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}
		
	}
	static int [] islandmap;
	static class island {
		int f_x;
		int f_y;
		int s_x;
		int s_y;
		public island(int f_x, int f_y, int s_x, int s_y) {
			super();
			this.f_x = f_x;
			this.f_y = f_y;
			this.s_x = s_x;
			this.s_y = s_y;
		}			
	}
	static boolean[] island_vist;
	
	static int find_set(int x) {
		if(x == islandmap[x] ) return x;
		return islandmap[x] = find_set(islandmap[x]);
	}
	static void union(int x, int y) {
		int fx = find_set(x);
		int fy = find_set(y);
		if(fx != fy) {
			islandmap[fx] = fy;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		is_visit = new boolean[N][M];
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<island> alIsland = new ArrayList<>();
		int holy=2;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 1) {
					bfs(j, i, holy);
					holy++;
				}
			}
		}
		//for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
		colormap = new int[holy][holy];		
		PriorityQueue<bridge> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] != 0) {
					find(j, i, map[i][j]);
				}
			}
		}
		//for(int i=0;i<holy;i++) System.out.println(Arrays.toString(colormap[i]));

		islandmap = new int[holy];
		for(int i=0;i<islandmap.length;i++) islandmap[i] = i;
		for(int i=2;i<holy;i++) {
			for(int j=i+1;j<holy;j++) {
				if(colormap[i][j] != 0) {
					pq.add(new bridge(i, j, colormap[i][j]));
				}
			}
		}
		int answer = 0;
		boolean is_end = false;
		if(!pq.isEmpty()) {
			island_vist = new boolean[holy];
			island_vist[pq.peek().start]=true;
			island_vist[pq.peek().end]=true;
			answer = pq.peek().distance;
			union(pq.peek().start, pq.peek().end);
			pq.poll();
			int cnt = 0;
			for(int i=2;i<islandmap.length;i++) {
				if (islandmap[i] == i) cnt++;
				if(cnt ==2) break;
			}
			if(cnt == 1) is_end = true;
		}
		
		while(!pq.isEmpty()) {
			//System.out.println("dodo");
			//System.out.println(Arrays.toString(islandmap)+" "+answer);
			if(is_end) break;
			bridge tmp = pq.poll();
			if(find_set(tmp.start) != find_set(tmp.end)) {
				//System.out.println("되는건가");
				answer+=tmp.distance;
				union(tmp.start, tmp.end);
				int cnt=0;
				for(int i=2;i<islandmap.length;i++) {
					if (islandmap[i] == i) cnt++;
					if(cnt ==2) break;
				}
				if(cnt == 1) is_end = true;
			}
		}
		if(is_end) System.out.println(answer);
		else System.out.println(-1);		
	}
	
	static final int dx[] = {0,-1,1,0};
	static final int dy[] = {-1,0,0,1};
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
	static void bfs(int x, int y, int holy) {
		map[y][x] = holy;
		for(int i=0;i<4;i++) {
			if(is_map(x+dx[i], y+dy[i])) {
				if(map[y+dy[i]][x+dx[i]] == 1) {
					map[y+dy[i]][x+dx[i]] = holy;
					bfs(x+dx[i], y+dy[i], holy);
				}				
			}
		}
	}
	static void find(int x, int y, int holy) {
		for(int i=y+1;i<N;i++) {
			if(map[i][x] != 0) {
				if(map[i][x] == holy) break;
				else {
					int color = map[i][x];
					int dis = i-y-1;
					if(dis <= 1) break;
					if(colormap[holy][color] == 0) {
						colormap[holy][color] = dis;
						colormap[color][holy] = dis;
						break;
					}else {
						if(dis < colormap[holy][color]) {
							colormap[holy][color] = dis;
							colormap[color][holy] = dis;
							break;
						}
					}
				}
			}
		}
		for(int i=x+1;i<M;i++) {
			if(map[y][i] != 0) {
				if(map[y][i] == holy) break;
				else {
					int color = map[y][i];
					int dis = i-x-1;
					if(dis <= 1) break;
					if(colormap[holy][color] == 0) {
						colormap[holy][color] = dis;
						colormap[color][holy] = dis;
						break;
					}else {
						if(dis < colormap[holy][color]) {
							colormap[holy][color] = dis;
							colormap[color][holy] = dis;
							break;
						}
					}
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
