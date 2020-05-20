package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main16398 {
	static int parents[];
	
	static int get_parents(int x) {
//		System.out.println(x);
		if(parents[x] < 0) return x;
		return parents[x] = get_parents(parents[x]);
	}
	static void union(int x, int y) {
		int px = get_parents(x);
		int py = get_parents(y);
		parents[px] += parents[py];
		parents[py]= px;
	}
	
	static class road implements Comparable<road>{
		int go;
		int to;
		int dis;
		public road(int go, int to, int dis) {
			super();
			this.go = go;
			this.to = to;
			this.dis = dis;
		}
		
		@Override
		public int compareTo(road o) {
			// TODO Auto-generated method stub
			return this.dis - o.dis;
		}
	}
	static int map[][], dis_map[], N;
	static boolean is_visit[];
	static PriorityQueue<road> pq = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
//		dis_map = new int[N];
		is_visit = new boolean[N];
//		for(int i=0;i<N;i++) {
//			dis_map[i] = Integer.MAX_VALUE;
//		}
		parents = new int[N];
		StringTokenizer st;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(j > i) pq.add(new road(i, j, map[i][j]));
			}
			parents[i] = -1;
		}
		long ans = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			int go = pq.peek().go;
			int to = pq.peek().to;
			int dis = pq.poll().dis;
			
			int px = get_parents(go);
			int py = get_parents(to);
			if(px == py) continue;
//			System.out.println(go+ " " + to + " "+ px+ " "+ py);
			ans += dis;
			union(go, to);
			int tmp = 0;
			for(int i=0;i<N;i++) {
				if(parents[i] < 0) tmp++;
				if(tmp > 1) break;
			}
			if(tmp == 1) break;
		}
		
//		end:for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				if(min == map[i][j]) {
//					ans += map[i][j];
//					is_visit[i] = true;
//					is_visit[j] = true;
//					for(int k=0;k<N;k++) {
//						if(i != k) {
//							pq.add(new road(k, map[i][k]));
//						}
//						if(j != k) {
//							pq.add(new road(j, map[j][k]));
//						}
//					}
//					
//					break end;
//				}
//			}
//		}
//		
//		while(!pq.isEmpty()) {
//			int now = pq.peek().go;
//			int nowdis = pq.poll().dis;
//			if(is_visit[now]) continue;
//			System.out.println(now+ " " + nowdis);
//			ans += nowdis;
//			is_visit[now] = true;
//			cnt++;
//			if(cnt == N) break;
//			for(int i=0;i<N;i++) {
//				if(!is_visit[i]) {
//					pq.add(new road(i, map[now][i]));
//				}
//			}
//			
//		}
		System.out.println(ans);
		
		
		
		
		
		
	}
}
