package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4041 {
	static pair list[] = new pair[100001];
	static pair anslist[] = new pair[100001];
	static boolean is_visit[] = new boolean[100001];
	static priorityQueue pq = new priorityQueue();
	static int min_x, min_y;
	static pair minpair;
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
	static class priorityQueue{
		pair pq[];
		int now;
		public priorityQueue() {
			pq = new pair[100001];
			int now = 0;
		}
		public void add(pair p) {
			pq[now] = p;
			int tmpnow = now++;
			if(tmpnow != 0) {
				int ccc = ccc(minpair, pq[(tmpnow-1)/2], pq[tmpnow]);
				if(ccc < 0 || ccc == 0 && dis(pq[(tmpnow-1)/2], pq[tmpnow])>0) {
					pair tmp = pq[(tmpnow-1)/2];
					pq[(tmpnow-1)/2] = pq[tmpnow];
					pq[tmpnow] = tmp;
					tmpnow=(tmpnow-1)/2;
				}else return;
			}			
		}
		public pair poll() {
			pair r = pq[0];
			now--;
			pq[0] = pq[now];
			int tmpnow = 0;
			while(tmpnow*2+1<now) {
				int child = tmpnow*2+1;
				if(child+1<now) {
					int ccc = ccc(minpair, pq[child], pq[child+1]);
					int dis = dis(pq[child], pq[child+1]);
					if(ccc < 0 || ccc == 0 && dis > 0) {
						child++;
					}					
				}
				int ccc = ccc(minpair, pq[tmpnow], pq[child]);
				int dis = dis(pq[tmpnow], pq[child]); 
				if(ccc < 0 || ccc==0 && dis>0) {
					pair tmp = pq[child];
					pq[child] = pq[tmpnow];
					pq[tmpnow] = tmp;
					tmpnow = child;
				}else return r;				
			}			
			return r;
		}
		
		
		
	}
	static int ccc(pair a, pair b, pair c) {
		int t = (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
		if(t>0) return 1;
		if(t<0) return -1;
		return 0;
	}
	static int dis(pair b, pair c) {
		return (b.x*b.x+b.y*b.y) - (c.x*c.x+c.y*c.y) ;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			min_y = 100001;
			min_x = 100001;
			for(int i=0;i<N;i++) {
				
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list[i] = new pair(x, y);
				if(y < min_y || y == min_y && x < min_x) {
					min_y = y;
					min_x = x;					
				}				
				//pq.add(new pair(x, y));
				
			}
			int now =2;
			pq.now = 0;
			minpair = new pair(min_x, min_y);
			for(int i=0;i<N;i++) {
				pq.add(list[i]);
			}
			anslist[0] = pq.poll();
			//System.out.println(anslist[0].x+" "+anslist[0].y);
			
			anslist[1] = pq.poll();
			//System.out.println(anslist[1].x+" "+anslist[1].y);
			
			//anslist[2] = pq.poll();
			//System.out.println(anslist[2].x+" "+anslist[2].y);
			
			while(pq.now != 0) {
				pair A = anslist[now-2];
				pair B = anslist[now-1];
				pair C = pq.poll();
				//System.out.println(C.x+" "+C.y);
				if(ccc(A,B,C) <= 0 && now == 2) {
					anslist[now-1] = C;
					continue;
				}
				while(ccc(A,B,C) <= 0 && now>2) {
					now--;
					A = anslist[now-2];
					B = anslist[now-1];					
				}
				anslist[now] = C;
				now++;
			}
			//for(int i=0;i<now;i++) System.out.println(anslist[i].x+" "+anslist[i].y);
			System.out.println("#"+tc+" "+now);
			
		}
	}
}
