package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1803 {
	static priorityQueue pq;
	static ArrayList al[];
	static long dismap[];
	
	static class dot{
		int go;
		long v;
		public dot(int go, long v) {
			super();
			this.go = go;
			this.v = v;
		}
		
	}
	static class priorityQueue{
		dot pq[];
		int now;
		public priorityQueue() {
			pq = new dot[300001];
			now = 0;
		}
		boolean is_empty() {
			if(now == 0) return true;
			return false;
		}
		
		void add(dot d) {
			pq[now] = d;
			int tmpnow = now;
			while(tmpnow>0) {
				if(pq[(tmpnow-1)/2].v > pq[tmpnow].v) {
					dot tmp = pq[tmpnow];
					pq[tmpnow] = pq[(tmpnow-1)/2];
					pq[(tmpnow-1)/2] = tmp;
					tmpnow = (tmpnow-1)/2;
				}else break;
			}			
			now++;
			//System.out.println(pq[0].go+" "+pq[0].v);
		}		
		dot poll() {
			dot poll = pq[0];
			now--;
			dot some = pq[now];
			pq[0] = some;
			int tmp = 0;
			while(tmp*2+1 < now) {
				int child = tmp*2+1;
				if(child+1<now && pq[child+1].v<pq[child].v) {
					child++;
				}
				/*System.out.println(now);
				System.out.println(tmp);
				System.out.println(child);
				System.out.println(pq[tmp].v);*/
				if(pq[tmp].v > pq[child].v) {
					dot tmpd = pq[tmp];
					pq[tmp] = pq[child];
					pq[child] = tmpd;
					tmp = child;
				}else break;
			}
			
			
			
			return poll;
		}
	}
	static class ArrayList{
		dot list[];
		int now;
		int size = 2;
		public ArrayList() {
			list = new dot[size];			
			now = 0;
		}
		void add(dot d) {
			if(now == size) {
				dot tmplist[] = new dot[size];
				for(int i=0;i<size;i++) tmplist[i] = list[i];
				list = new dot[size+size/2];
				for(int i=0;i<size;i++) list[i] = tmplist[i];
				size += (size/2);
			}
			list[now++] = d;			
		}
		dot get(int i) {
			return list[i];
		}
		
		
		
	}
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			al = new ArrayList[N+1];
			pq = new priorityQueue();
			dismap = new long[N+1];
			
			for(int i=0;i<=N;i++) {
				al[i] = new ArrayList();
				dismap[i] = -1;
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				al[s].add(new dot(e, v));
				al[e].add(new dot(s, v));
			}
			pq.add(new dot(S, 0));
			//dismap[S] = 0;
			while(!pq.is_empty()) {
				//System.out.println(1);
				int s = pq.pq[0].go;
				long v = pq.pq[0].v;
				pq.poll();
				if(dismap[s] != -1) continue;
				dismap[s] = v;
				//System.out.println(s+" "+v);
				for(int i=0;i<al[s].now;i++) {
					if(dismap[al[s].get(i).go] == -1)
					pq.add(new dot(al[s].get(i).go, al[s].get(i).v +v));						
					
				}
			}
			System.out.println("#"+tc+" "+dismap[E]);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
