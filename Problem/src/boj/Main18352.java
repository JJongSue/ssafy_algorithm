package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main18352 {
	static long dis_map[];
	static ArrayList<Integer> al[];
	static PriorityQueue<dot> pq = new PriorityQueue<dot>();
	static class dot implements Comparable<dot>{
		int x;
		long dis;
		public dot(int x, long dis) {
			super();
			this.x = x;
			this.dis = dis;
		}
		@Override
		public int compareTo(dot o) {
			// TODO Auto-generated method stub
			return Long.compare(this.dis, o.dis);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		dis_map = new long[N+1];
		al = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			
			dis_map[i] = Long.MAX_VALUE;
			al[i] = new ArrayList<>();
		}
		
		pq.add(new dot(X, 0));
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int go = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			al[go].add(end);
		}
		
		while(!pq.isEmpty()) {
			int go = pq.peek().x;
			long dis = pq.poll().dis;
			if(dis_map[go] < dis) continue;
			dis_map[go] = dis;
			for(int i=0;i<al[go].size();i++) {
				int togo = al[go].get(i);
				if(dis_map[togo] > dis+1 && dis+1 <= K) {
					dis_map[togo] = dis+1;
					pq.add(new dot(togo, dis+1));
				}
			}
			
		}
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			//System.out.println(dis_map[i]);
			if(dis_map[i] == K) {
				cnt++;
				System.out.println(i);
			}
		}
		if(cnt == 0) System.out.println(-1);
		
	}
}
