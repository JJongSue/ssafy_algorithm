package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4006 {
	static int parents[] = new int[50001];
	static priorityQueue pq = new priorityQueue();
	
	static int find_set(int x) {
		if(parents[x] < 0) return x;
		return parents[x] = find_set(parents[x]);
	}
	
	static void union(int x, int y) {
		int px = find_set(x);
		int py = find_set(y);
		if(px != py) {
			parents[px] += parents[py];
			parents[py] = px;
		}
	}
	
	static class line{
		int s;
		int e;
		int dis;
		public line(int s, int e, int dis) {
			super();
			this.s = s;
			this.e = e;
			this.dis = dis;
		}
		
	}

	static class priorityQueue{
		line pq[];
		int now;
		public priorityQueue() {
			pq = new line[200001];
			now = 0;
			// TODO Auto-generated constructor stub
		}
		public void add(line line) {
			pq[now] = line;
			int tmpnow = now;
			while(tmpnow != 0) {
				if(pq[tmpnow].dis < pq[(tmpnow-1)/2].dis) {
					line tmp = pq[(tmpnow-1)/2];
					pq[(tmpnow-1)/2] = pq[tmpnow];
					pq[tmpnow] = tmp;
					tmpnow = (tmpnow-1)/2;
				}else break;
			}
			now++;			
		}
		public line poll() {
			line r = pq[0];
			pq[0] = pq[now-1];
			now--;
			int tmpnow = 0;
			while(tmpnow*2+1 < now) {
				int child = tmpnow*2+1;
				if(child+1<now && pq[child].dis>pq[child+1].dis) child++;
				if(pq[tmpnow].dis>pq[child].dis) {
					line tmp = pq[tmpnow];
					pq[tmpnow] = pq[child];
					pq[child] = tmp;
					tmpnow = child;
				}else break;
			}			
			return r;
		}
	}	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			for(int i=1;i<=N;i++) parents[i] = -1;
			pq.now = 0;
			for(int i=0;i<M;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				pq.add(new line(s, e, dis));
			}
			int ans = 0;
			while(pq.now != 0) {
				int cnt = 0;
				for(int i=1;i<=N;i++) {
					if(parents[i]<0) cnt++;
					if(cnt>1) break;
				}
				if(cnt == 1) break;
				int s = pq.pq[0].s;
				int e = pq.pq[0].e;
				int dis = pq.poll().dis;
				
				int fs = find_set(s);
				int fe = find_set(e);
				if(fs != fe) {
					union(s,e);
					ans+=dis;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
