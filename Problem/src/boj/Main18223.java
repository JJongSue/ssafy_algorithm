package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main18223 {
	static int dis_map[];
	static int N, M, des;
	static ArrayList<pair> ll[];
	static PriorityQueue<pair> pq;
	static class pair implements Comparable<pair>{
		int go;
		int dis;
		public pair(int go, int dis) {
			super();
			this.go = go;
			this.dis = dis;
		}
		@Override
		public int compareTo(pair o) {
			return this.dis - o.dis;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		des = Integer.parseInt(st.nextToken());
		
		dis_map = new int[N+1];
		ll = new ArrayList[N+1];
		pq = new PriorityQueue<pair>();
		
		for(int i=0;i<=N;i++) {
			dis_map[i] = 987654321;
			ll[i] = new ArrayList<pair>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			ll[x].add(new pair(y, dis));
			ll[y].add(new pair(x, dis));
		}
		
		dis_map[1] = 0;
		pq.add(new pair(1, 0));
		
		while(!pq.isEmpty()) {
			int go = pq.peek().go;
			int dis = pq.poll().dis;
			if(dis > dis_map[go]) continue;
			for(int i=0;i<ll[go].size();i++) {
				int xx = ll[go].get(i).go;
				int disdis = dis + ll[go].get(i).dis;
				if(disdis < dis_map[xx]) {
					dis_map[xx] = disdis;
					pq.add(new pair(xx, disdis));
				}
			}
		}
		int ansgo = dis_map[N];
		int togo = dis_map[des];
		
		for(int i=0;i<=N;i++) {
			dis_map[i] = 987654321;
		}
		dis_map[des] = 0;
		pq.add(new pair(des, 0));
		
		while(!pq.isEmpty()) {
			int go = pq.peek().go;
			int dis = pq.poll().dis;
			if(dis > dis_map[go]) continue;
			for(int i=0;i<ll[go].size();i++) {
				int xx = ll[go].get(i).go;
				int disdis = dis + ll[go].get(i).dis;
				if(disdis < dis_map[xx]) {
					dis_map[xx] = disdis;
					pq.add(new pair(xx, disdis));
				}
			}
		}
		togo += dis_map[N];
		if(ansgo == togo) System.out.println("SAVE HIM");
		else System.out.println("GOOD BYE");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
