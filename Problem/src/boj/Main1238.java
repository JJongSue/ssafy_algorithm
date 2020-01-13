package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1238 {
	static ArrayList al[], al2[];
	static pq pq = new pq();
	static pq pq2 = new pq();
	static int ans[], ans2[];
	
	static class ArrayList{
		dot list[];
		int size;
		int now;
		public ArrayList() {
			size = 2;
			now = 0;
			list = new dot[size];
		}
		public void add(dot x) {
			if(size == now) {
				dot tmp[] = new dot[size];
				for(int i=0;i<size;i++) tmp[i] = list[i];
				list = new dot[size+(size>>1)];
				for(int i=0;i<size;i++) list[i] = tmp[i];
				size = size + (size>>1);
			}
			list[now++] = x;
		}
	}
	static class pq{
		dot q[];
		int size;
		public pq() {
			size = 0;
			q = new dot[10001];
		}
		
		public void add(dot x) {
			q[size] = x;
			int now = size;
			while(now != 0) {
				if(q[now].dis < q[(now-1)/2].dis) {
					dot tmp = q[now];
					q[now] = q[(now-1)/2];
					q[(now-1)/2] = tmp;	
				}else break;
				now = (now-1)/2;
			}
			size++;
		}
		public dot poll() {
			dot ret = q[0];
			q[0] = q[--size];
			int now = 0;
			while(now*2 + 1 < size) {
				int chi = now * 2 + 1;
				if(chi + 1 < size && q[chi+1].dis < q[chi].dis) {
					chi++;
				}
				if(q[now].dis > q[chi].dis) {
					dot tmp = q[now];
					q[now] = q[chi];
					q[chi] = tmp;
				}else break;
				now = (now*2)+1;
				
			}
			
			return ret;
		}
		
		
	}
	
	static class dot{
		int x;
		int dis;
		public dot(int x, int dis) {
			super();
			this.x = x;
			this.dis = dis;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ans = new int[N+1];
		al = new ArrayList[N+1];
		ans2 = new int[N+1];
		al2 = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			al[i] = new ArrayList();
			al2[i] = new ArrayList();
			ans[i] = Integer.MAX_VALUE;
			ans2[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int e = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			al[s].add(new dot(e, dis));
			al2[e].add(new dot(s, dis));
		}
		pq.add(new dot(K, 0));
		pq2.add(new dot(K,0));
		ans[K] = 1;
		ans2[K] = 1;
		while(pq.size != 0 ) {
			int x = pq.q[0].x;
			int dis = pq.poll().dis;
			if(dis > ans[x]) continue;
			for(int i=0;i<al[x].now;i++) {
				int xx = al[x].list[i].x;
				int godis = al[x].list[i].dis;
				
				if(godis+dis < ans[xx]) {
					ans[xx] = godis+dis;
					pq.add(new dot(xx, godis+dis));
				}
			}
		}
		
		while(pq2.size != 0 ) {
			int x = pq2.q[0].x;
			int dis = pq2.poll().dis;
			if(dis > ans2[x]) continue;
			for(int i=0;i<al2[x].now;i++) {
				int xx = al2[x].list[i].x;
				int godis = al2[x].list[i].dis;
				
				if(dis+godis < ans2[xx]) {
					ans2[xx] = dis+godis;
					pq2.add(new dot(xx, godis+dis));
				}
			}
		}
		int max = 0;
		for(int i=1;i<=N;i++) {
			max = Math.max(max, ans[i]+ans2[i]);
		}
		System.out.println(max);
		
	}
	
}
