package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1647 {
	static int parents[];
	static int find(int x) {
		if(x == parents[x]) return x;
		//while(x == parents[x]) x = parents[x];
		return parents[x]=find(parents[x]);
	}
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		parents[py] = px;
	}
	static PriorityQueue<dot> pq;
	
	
	static class dot implements Comparable<dot>{
		int x;
		int y;
		int dis;
		public dot() {
			super();
			// TODO Auto-generated constructor stub
		}
		public dot(int x, int y, int dis){
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
		@Override
		public int compareTo(dot o) {
			// TODO Auto-generated method stub
			return this.dis-o.dis;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		parents = new int[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new dot(a, b, c));			
		}
		for(int i=0;i<=N;i++) parents[i] = i;
		
		boolean is_end = true;
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			if(parents[i] == i) cnt++;
			if(cnt == 2) {
				is_end= false;
				break;
			}
		}
		if(is_end) System.out.println(0);
		else {
			long ans = 0;
			is_end = true;
			while(!pq.isEmpty()) {
				dot tmp = pq.poll();
				if(find(tmp.x) == find(tmp.y)) continue;
				ans += tmp.dis;
				union(tmp.x, tmp.y);
				is_end = true;
				cnt = 0;
				for(int i=1;i<=N;i++) {
					if(parents[i] == i) cnt++;
					if(cnt > 2) {
						is_end=false;
						break;
					}
				}
				if(is_end) {					
					break;
				}
			}
			System.out.println(ans);
		}
		
		
		
	}
}
