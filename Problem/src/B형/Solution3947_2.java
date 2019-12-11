package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3947_2 {
	static int[] parents;
	static priorityQueue pq;
	static ArrayList al[];
	
	static class road{
		int x;
		int dis;
		public road(int x, int dis) {
			super();
			this.x = x;
			this.dis = dis;
		}		
	}
	
	
	static class priorityQueue{
		road pq[];
		int now;
		public priorityQueue() {
			pq = new road[1000001];
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
	static class ArrayList{
		road pair[];
		int now = 0;
		int size;
		public ArrayList() {
			size = 2;
			pair = new road[size];
		}
		void add(road x) {
			if(now == size) {
				road tmpp[] = new road[size];
				for(int i=0;i<size;i++) {
					tmpp[i] = pair[i];									
				}
				pair = new road[size+size/2];
				for(int i=0;i<size;i++) {
					pair[i] = tmpp[i];				
				}
				size += (size/2);
			}
			pair[now] = x;
			
			now++;
		}
		road get(int x) {
			return pair[x];
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
			al = new ArrayList[N+1];
			for(int i=1;i<=N;i++) {
				parents[i] = -1;
				al[i] = new ArrayList();
			}
			
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				al[x].add(new road(y, dis));
				al[y].add(new road(x, dis));
				//pq.add(new road(x, y, dis));
			}
			long ans = 0;
			pq.add(new road(1, 0));
			while(!pq.is_empty()) {
				int cnt = 0;
				for(int i=1;i<=N;i++) {
					if(parents[i] < 0) cnt++;
					if(cnt>1) break;
				}
				if(cnt == 0) break;
				int x = pq.pq[0].x;
				int dis = pq.poll().dis;
				if(parents[x] != -1) continue;
				parents[x] = dis;
				//System.out.println(x+" "+dis);
				
				ans +=dis;
				for(int i=0;i<al[x].now;i++) {
					if( parents[al[x].get(i).x] ==-1) {
						
						pq.add(new road(al[x].get(i).x, al[x].get(i).dis));
						
					}
				}
				
			}
			System.out.println("#"+tc+" "+ans);
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
