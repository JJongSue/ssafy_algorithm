package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3820 {
	static priorityQueue pq;
	
	static class pair{
		int first;
		int second;
		public pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
	}
	static class priorityQueue{
		pair queue[];
		int now;
		public priorityQueue() {
			now = 0;
			queue = new pair[200001];
		}
		
		void add(pair x) {
			queue[now] = x;
			int tmp = now;
			while(tmp > 0) {
				if( queue[(tmp-1)/2].second > queue[tmp].second  ) {
					pair tmpq = queue[(tmp-1)/2];
					queue[(tmp-1)/2] = queue[tmp];
					queue[tmp] = tmpq;
					tmp = (tmp-1)/2;
				}else if(queue[(tmp-1)/2].second == queue[tmp].second && queue[(tmp-1)/2].first < queue[tmp].first) {
					pair tmpq = queue[(tmp-1)/2];
					queue[(tmp-1)/2] = queue[tmp];
					queue[tmp] = tmpq;
					tmp = (tmp-1)/2;
				}else break;
			}
			now++;
		}
		
		pair poll() {
			pair r = queue[0];
			queue[0] = queue[--now];
			int tmp = 0;
			while( tmp*2+1 < now ) {
				if( queue[tmp*2+1].second < queue[tmp].second  ) {
					pair tmpq = queue[tmp*2+1];
					queue[tmp*2+1] = queue[tmp];
					queue[tmp] = tmpq;
					tmp = tmp*2+1;
				}else if(queue[tmp*2+1].second == queue[tmp].second && queue[tmp*2+1].first > queue[tmp].first) {
					pair tmpq = queue[tmp*2+1];
					queue[tmp*2+1] = queue[tmp];
					queue[tmp] = tmpq;
					tmp = tmp*2+1;
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
			pq = new priorityQueue();
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				pq.add(new pair(first, second));
			}
			long v = 1;
			for(int i=0;i<N;i++) {
				pair tmp = pq.poll();
				v = (v*tmp.first+tmp.second)%1000000007;
			}
			System.out.println("#"+tc+" "+v);
		}
		
		
	}
}
