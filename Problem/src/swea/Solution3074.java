package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution3074 {
	static class pair implements Comparable<pair>{
		long time;
		long now;
		public pair(long time, long now) {
			super();
			this.time = time;
			this.now = now;
		}
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if( this.now+this.time == o.now+o.time) return Long.compare(this.time, o.time);
			return Long.compare(this.now+this.time, o.now+o.time);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			PriorityQueue<pair> pq = new PriorityQueue<>();
			for(int i=0;i<N;i++) {
				int time = Integer.parseInt(br.readLine());
				pq.add(new pair(time, 0));				
			}
			if(N >= M) System.out.println("#"+tc+" 0");
			else {
				long ans=0;
				for(int i=0;i<M;i++) {
					pair tmp = pq.poll();
					tmp.now+=tmp.time;
					pq.add(tmp);
					if( ans < tmp.now ) {
						ans = tmp.now;
					}
				}
				System.out.println("#"+tc+" "+ans);
				
			}
		}
	}
}

