package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution4007 {
	
	static priorityQueue pq;
	static ArrayList<pair> al[] = new ArrayList[50001];
	static ArrayList<pair> al2[] = new ArrayList[50001];
	//static ArrayList al[] = new ArrayList[50001];
	//static ArrayList al2[] = new ArrayList[50001];
	static boolean is_visit[] = new boolean[50001];
	static long dismap[] = new long[50001];
	static long dismap2[] = new long[50001];
	
	static class priorityQueue{
		pair pq[];
		int now;
		public priorityQueue() {
			pq = new pair[500001];
			now = 0;
		}
		public void add(pair d) {
			pq[now] = d;
			int tmpnow = now;
			while(tmpnow!=0) {
				if(pq[tmpnow].dis < pq[(tmpnow-1)/2].dis) {
					pair tmp = pq[(tmpnow-1)/2];
					pq[(tmpnow-1)/2] = pq[tmpnow];
					pq[tmpnow] = tmp;
					tmpnow = (tmpnow-1)/2;
				}else break;
			}
			now++;
		}
		public pair poll() {
			pair r = pq[0];
			now--;
			pq[0] = pq[now];
			int tmpnow = 0;
			while(tmpnow*2+1<now) {
				int child = tmpnow*2+1;
				if(child+1<now && pq[child].dis > pq[child+1].dis) child++;
				if(pq[tmpnow].dis > pq[child].dis) {
					pair tmp = pq[child];
					pq[child] = pq[tmpnow];
					pq[tmpnow] = tmp;
					tmpnow = child;
				}else break;
			}
			return r;
		}
		
		
		
	}
	static class pair{
		int go;
		long dis;
		public pair(int go, long dis) {
			super();
			this.go = go;
			this.dis = dis;
		}
	}
	static class Node{
		
	}
	
	/*
	static class ArrayList{
		pair al[];
		int size;
		int now;
		public ArrayList() {
			now = 0;
			size = 2;
			al = new pair[size];
		}
		public void add(pair pair) {
			if(now == size) {
				pair tmp[] = new pair[size];
				for(int i=0;i<size;i++) {
					tmp[i] = al[i];
				}
				al = new pair[size+(size/2)];
				for(int i=0;i<size;i++) {
					 al[i] = tmp[i];
				}
			}
			al[now] = pair;
			now++;
		}
		public pair get(int x) {
			return al[x];
		}
		
		
	}*/
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		pq = new priorityQueue();
		
		
		for(int i=1;i<=50000;i++) {
			al[i] = new ArrayList();
			al2[i] = new ArrayList();
		}
		
		for(int tc=1;tc<=T;tc++) {
			pq.now = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			for(int i=1;i<=N;i++) {
				al[i] = new ArrayList<pair>();
				al2[i] = new ArrayList<pair>();
				//al[i].now=0;
				//al2[i].now=0;
				dismap[i] = 500000000;
				dismap2[i] = 500000000;
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());

				al[s].add(new pair(e, dis));
				al2[e].add(new pair(s, dis));
			}
			pq.add(new pair(X, 0));
			dismap[X] = 0;
			
			for(int i=1;i<=N;i++) is_visit[i] = false;
			while(pq.now != 0) {
				//int s = pq.pq[0].s;
				int e = pq.pq[0].go;
				long dis = pq.poll().dis;
				if(is_visit[e]) continue;
				is_visit[e] = true;
				
				for(int i=0;i<al[e].size();i++) {
					int go = al[e].get(i).go;
					long godis = al[e].get(i).dis;
					if(dismap[go] > dismap[e]+godis) {
						dismap[go] = dismap[e]+godis;
						pq.add(new pair(go, dismap[go]));
					}
				}
			}

			
			for(int i=1;i<=N;i++) {
				is_visit[i] = false;
			}
			pq.now = 0;
			pq.add(new pair(X, 0));
			dismap2[X] = 0;
			while(pq.now != 0) {
				//int s = pq.pq[0].s;
				int e = pq.pq[0].go;
				long dis = pq.poll().dis;
				if(is_visit[e]) continue;
				is_visit[e] = true;				
				for(int i=0;i<al2[e].size();i++) {
					int go = al2[e].get(i).go;
					long godis = al2[e].get(i).dis;
					if(dismap2[go] > dismap2[e]+godis) {
						dismap2[go] = dismap2[e]+godis;
						pq.add(new pair(go, dismap2[go]));
					}
				}
	
			}

			long x = 0;
			for(int i=1;i<=N;i++) {
				if(i == X) continue;
				dismap[i] += dismap2[i];
				if(dismap[i] > x) x = dismap[i];
			}
			System.out.println("#"+tc+" "+x);
		}
	
	}
}
