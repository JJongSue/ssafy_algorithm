package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3947 {
	static int[] parents;
	static priorityQueue pq;
	
	static class road{
		int x;
		int y;
		int dis;
		public road(int x, int y, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}		
	}
	
	static int find_set(int x) {
		if(parents[x] < 0) return x;
		return parents[x] = find_set(parents[x]);
	}
	static void union(int x, int y) {
		int px = find_set(x);
		int py = find_set(y);
		if(px != py) {
			if(parents[px] < parents[py]) {
				parents[px] += parents[py];
				parents[py] = px;				
			}else {
				parents[py] += parents[px];
				parents[px] = py;
			}
		}
	}
	
	static class priorityQueue{
		road pq[];
		int now;
		public priorityQueue() {
			pq = new road[500001];
		}
		
		void add(road r) {
			pq[now] = r;
			int tmpnow = now;
			while(tmpnow!=0) {
				if(pq[(tmpnow-1)/2].dis > pq[tmpnow].dis ) {
					road tmp = pq[(tmpnow-1)/2];
					pq[(tmpnow-1)/2] = pq[tmpnow];
					pq[tmpnow] = tmp;
					
					tmpnow = (tmpnow-1)/2;
				}else break;
			}
			now++;
		}
		road poll() {
			road poll = pq[0];
			now--;
			pq[0] = pq[now];
			int tmpnow = 0;
			while(tmpnow*2+1<now) {
				int child = tmpnow*2+1;
				if(child+1 < now && pq[child].dis > pq[child+1].dis) {
					child++;
				}
				if(pq[child].dis < pq[tmpnow].dis) {
					road tmp = pq[child];
					pq[child] = pq[tmpnow];
					pq[tmpnow] = tmp;
					
					tmpnow = child;
				}else {
					break;
				}
			}
			
			
			
			return poll;
		}
		boolean is_empty() {
			if(now == 0) return true;
			return false;
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			pq = new priorityQueue();
			long ans = 0;
			for(int i=1;i<=N;i++) parents[i] = -1;
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				if(x == 1 || y==1) {
					parents[x] = 1;
					parents[y] = 1;
					ans +=dis;
				}
				else pq.add(new road(x, y, dis));
			}
			parents[1] = -1;
			while(!pq.is_empty()) {
				int cnt = 0;
				for(int i=1;i<=N;i++) {
					if(parents[find_set(i)] < 0) cnt++;
					if(cnt>1) break;
				}
				if(cnt == 1) break;
				
				int x = pq.pq[0].x;
				int y = pq.pq[0].y;
				int dis = pq.poll().dis;
				int px = find_set(x);
				int py = find_set(y);
				if(px != py) {
					union(x, y);
					ans+=dis;
				}
			}
			System.out.println("#"+tc+" "+ans);
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
