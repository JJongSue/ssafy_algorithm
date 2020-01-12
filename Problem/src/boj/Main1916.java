package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1916 {
	static int N, M, dis_map[];
	static ArrayList<dot> al[];
	static PriorityQueue<dot> pq = new PriorityQueue<dot>();
	
	static class dot implements Comparable<dot>{
		int go;
		int dis;
		public dot(int go, int dis) {
			super();
			this.go = go;
			this.dis = dis;
		}
		@Override
		public int compareTo(dot o) {
			// TODO Auto-generated method stub
			return this.dis - o.dis;
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dis_map = new int[N+1];
		al = new ArrayList[N+1];
		
		StringTokenizer st;
		
		
		for(int i=1;i<=N;i++) {
			al[i] = new ArrayList<dot>();
			dis_map[i] = Integer.MAX_VALUE;
			/*for(int j=1;j<=N;j++) {
				dis_map[i][j] = -1; 
			}*/
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int go = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			al[x].add(new dot(go, dis));
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		dis_map[x] = 0;
		
		for(int i=0;i<al[x].size();i++) {
			pq.add(al[x].get(i));
		}
		
		while(!pq.isEmpty()) {
			int now = pq.peek().go;
			int dis = pq.poll().dis;
			if(dis > dis_map[now]) continue;
			dis_map[now] = dis;
			for(int i=0;i<al[now].size();i++) {
				int go = al[now].get(i).go;
				int godis = al[now].get(i).dis + dis;
				if(godis < dis_map[go]) {
					pq.add(new dot(go, godis));
				}
			}
			
		}
		System.out.println(dis_map[y]);
	}
}
