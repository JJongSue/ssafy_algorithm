package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main11779 {
	static ArrayList<road> al[];
	static ArrayList<Integer> line[];
	static PriorityQueue<road> pq = new PriorityQueue<>();
	static int dis_map[];
	static class road implements Comparable<road>{
		int x;
		int dis;
		public road(int x, int dis) {
			super();
			this.x = x;
			this.dis = dis;
		}
		@Override
		public int compareTo(road o) {
			return this.dis - o.dis;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		al = new ArrayList[N+1];
		line = new ArrayList[N+1];
		dis_map = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			dis_map[i] = 987654321;
			al[i] = new ArrayList<>();
			line[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			al[x].add(new road(y, dis));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		dis_map[s] = 0;
		pq.add(new road(s, 0));
		while(!pq.isEmpty()) {
			int x = pq.peek().x;
			int dis = pq.poll().dis;
			if(dis_map[x] < dis) continue;
			for(int i=0;i<al[x].size();i++) {
				int xx = al[x].get(i).x;
				int todis = al[x].get(i).dis + dis_map[x];
				if(todis < dis_map[xx]) {
					line[xx] = new ArrayList<>();
					for(int j=0;j<line[x].size();j++) line[xx].add(line[x].get(j));
					line[xx].add(x);
					dis_map[xx] = todis;
					pq.add(new road(xx, todis));
				}
			}
		}
		System.out.println(dis_map[e]);
		System.out.println(line[e].size()+1);
		for(int i=0;i<line[e].size();i++) {
			System.out.print(line[e].get(i)+" ");
		}System.out.println(e);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
