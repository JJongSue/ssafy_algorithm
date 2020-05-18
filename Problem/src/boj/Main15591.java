package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main15591 {
	static class pair implements Comparable<pair>{
		int e;
		int dis;
		public pair(int e, int dis) {
			super();
			this.e = e;
			this.dis = dis;
		}
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.dis - o.dis;
		}
		
	}
	static ArrayList<pair> al[];
	static int dismap[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		al = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			al[i] = new ArrayList<>();
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			al[s].add(new pair(e, dis));
			al[e].add(new pair(s, dis));
		}
		for(int tc=0;tc<M;tc++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			dismap = new int[N+1];
			for(int i=1;i<=N;i++) {
				dismap[i] = Integer.MIN_VALUE;
			}
			
			PriorityQueue<pair> pq = new PriorityQueue<>();
			
			for(int i=0;i<al[start].size();i++) {
				int now = al[start].get(i).e;
				int dis = al[start].get(i).dis;
				dismap[now] = dis;
				pq.add(new pair(now, dis));
			}
			
			while(!pq.isEmpty()) {ef
				int now = pq.peek().e;
				int dis = pq.poll().dis;
				
				for(int i=0;i<al[now].size();i++) {
					int go = al[now].get(i).e;
					int godis = al[now].get(i).dis;
					if(dismap[go] == Integer.MIN_VALUE) {
						dismap[go] = Math.min(godis, dis);
						pq.add(new pair(go, dismap[go]));
					}
				}
			}
			int ans = 0;
			for(int i=1;i<=N;i++) {
				if(i != start && dismap[i] >= K) ans++;
			}
			System.out.println(ans);
			
		}
		
	}
}
