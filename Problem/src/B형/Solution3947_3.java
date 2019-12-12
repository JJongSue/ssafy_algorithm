package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3947_3 {
	static BufferedReader br;
	//static int parents[] = new int[200001];	
	//static priorityQueue pq = new priorityQueue();
	static ArrayList al[] = new ArrayList[200001];
	static long parents[] = new long[200001];
	static long ans;
	static StringTokenizer st;
	static class dot{
		int x;
		int dis;
		public dot(int x, int dis) {
			super();
			this.x = x;
			this.dis = dis;
		}
		
	}
	static class priorityQueue{
		road pq[];
		int now=0;
		public priorityQueue() {
			pq = new road[500001];
		}
		
		void add(road r) {
			pq[now] = r;
			int tmpnow = now;
			while(tmpnow!=0) {
				if(pq[(tmpnow-1)/2].dis > pq[tmpnow].dis || 
						(pq[(tmpnow-1)/2].dis == pq[tmpnow].dis && pq[(tmpnow-1)/2].sum > pq[tmpnow].sum)) {
					road tmp = pq[(tmpnow-1)/2];
					pq[(tmpnow-1)/2] = pq[tmpnow];
					pq[tmpnow] = tmp;
					
					tmpnow = (tmpnow-1)/2;
				}else {
					break;
				}
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
				if(child+1 < now && 
						(pq[child].dis > pq[child+1].dis
						|| (pq[child].dis == pq[child+1].dis && pq[child].sum > pq[child+1].sum) )) {
					child++;
				}
				if(pq[child].dis < pq[tmpnow].dis ||
						(pq[child].dis == pq[tmpnow].dis && pq[child].sum < pq[tmpnow].sum )) {
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
	static class Node{
		dot pair;
		Node next;
		public Node(dot pair, Node next) {
			super();
			this.pair = pair;
			this.next = next;
			
		}
		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	}
	static Node[] tmp = new Node[1000001];
	static int idx=0;
	static class ArrayList{
		//dot pair[];
		Node pair;
		int now = 0;		
		public ArrayList() {
			
			//pair = new dot[size];
		}
		public ArrayList(Node pair) {
			super();
			this.pair = pair;
			this.now = now;
		}
		void add(dot x) {
			if(now == 0) {
				tmp[idx] = new Node(x, null);
				pair = tmp[idx];
				idx++;
			}else {
				tmp[idx] = new Node(x, pair);
				pair = tmp[idx];
				idx++;
			}
			now++;
			/*
			if(now == size) {
				dot tmpp[] = new dot[size];
				for(int i=0;i<size;i++) {
					tmpp[i] = pair[i];									
				}
				pair = new dot[size+size/2];
				for(int i=0;i<size;i++) {
					pair[i] = tmpp[i];				
				}
				size += (size/2);
			}
			pair[now] = x;
			
			now++;*/
		}
		/*dot get(int x) {
			return pair[x];
		}*/
	}
	
	
	static class road implements Comparable<road>{
		int x;
		long dis;
		int sum;
		public road(int x, long dis, int sum) {
			super();
			this.x = x;
			this.dis = dis;
			this.sum = sum;
		}
		@Override
		public int compareTo(road o) {
			if(this.dis == o.dis) {
				return this.sum-o.sum;
			}
			return Long.compare(this.dis,o.dis);
		}		
	}
	
	

	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<200001;i++) {
			
			al[i] = new ArrayList();
			//al[i].now = 0;
		}
		for(int i=1;i<1000001;i++) {
			
			tmp[i] = new Node();
			//al[i].now = 0;
		}
		for(int tc=1;tc<=T;tc++) {
			idx = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			priorityQueue pq = new priorityQueue();
			//pq = new priorityQueue();
			//al = new ArrayList[N+1];
			//pq = new PriorityQueue<>();
			//parents = new int[N+1];
			for(int i=1;i<=N;i++) {
				parents[i] = -1;
				//al[i] = new ArrayList();
				al[i].now = 0;
			}
			
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				al[x].add(new dot(y, dis));
				al[y].add(new dot(x, dis));
				//pq.add(new road(x, y, dis));
			}
			ans = 0;
			pq.add(new road(1, 0, 0));
			int cnt = 0;
			while(!pq.is_empty()) {
				/*int cnt = 0;
				for(int i=1;i<=N;i++) {
					if(parents[i] < 0) cnt++;
					if(cnt>1) break;
				}*/
				if(cnt == N) break;
				int x = pq.pq[0].x;
				int sum = pq.pq[0].sum;
				long dis = pq.poll().dis;
				
				if(parents[x] != -1) continue;
				parents[x] = dis;
				//System.out.println(x+" "+dis);
				cnt++;
				ans +=sum;
				Node tmp1 = al[x].pair;
				while(tmp1 != null) {
					System.out.println(al[x].pair.pair.x+"되는겨");
					if(parents[al[x].pair.pair.x] == -1) {						
						pq.add(new road(al[x].pair.pair.x, parents[al[x].pair.pair.x]+al[x].pair.pair.dis,al[x].pair.pair.dis));
					}
					tmp1 = tmp1.next;
				}
				/*for(int i=0;i<al[x].now;i++) {
					if( parents[al[x].get(i).x] ==-1) {						
						pq.add(new road(al[x].get(i).x, al[x].get(i).dis+parents[x], al[x].get(i).dis));
					}
				}*/
				
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}
		br.close();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
