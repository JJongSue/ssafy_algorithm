package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main17940 {
	static int[] company;
	static int[][] map;
	static ArrayList<subway> dis[];
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	static class subway implements Comparable<subway>{
		int now;
		int c;
		int dis;
		public subway(int now, int c, int dis) {
			super();
			this.now = now;
			this.c = c;
			this.dis = dis;
		}
		@Override
		public int compareTo(subway o) {
			if(this.c == o.c) return this.dis-o.dis;
			return this.c-o.c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		company = new int[N];
		map = new int[N][2];
		dis = new ArrayList[N];
		
		for(int i=0;i<N;i++) {
			dis[i] = new ArrayList<subway>();
			company[i] = Integer.parseInt(br.readLine());
			map[i][0] = 987654321;
			map[i][1] = 987654321;
			
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());			
			for(int j=0;j<N;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp != 0) {
					if(company[i] != company[j]) dis[i].add(new subway(j, 1, tmp));
					else dis[i].add(new subway(j, 0, tmp));
				}
			}
		}
		map[0][0] = 0;
		map[0][1] = 0;
		pq.add(0);
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			for(int i=0;i<dis[now].size();i++) {
				int go = dis[now].get(i).now;
				int cc = dis[now].get(i).c;
				int disgo = dis[now].get(i).dis;
				
				if(map[go][0] > map[now][0]+cc) {
					map[go][0] = map[now][0]+cc;
					map[go][1] = map[now][1]+disgo;
					pq.add(go);
				}else if(map[go][0] == map[now][0]+cc && map[go][1] > map[now][1]+disgo) {					
					map[go][1] = map[now][1]+disgo;
					pq.add(go);
				}
				
			}
		}
		System.out.println(map[M][0]+" "+map[M][1]);
		
		
		
		
	}
}
