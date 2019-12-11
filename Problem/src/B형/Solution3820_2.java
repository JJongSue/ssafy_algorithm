package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution3820_2 {
	static PriorityQueue<pair> pq;
	static class pair implements Comparable<pair>{
		long first;
		long second;
		public pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		@Override
		public int compareTo(pair o) {
			if(this.first == o.second) {
				return Long.compare(this.second,o.second);
			}
			if(this.second == o.second) {
				return Long.compare(o.first,this.first);
			}
			
			return Long.compare(((this.first*2+this.second)*o.first+o.second)
					,((o.first*2+o.second)*this.first+this.second));
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			pq = new PriorityQueue<>();
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				pq.add(new pair(first, second));
			}
			long v = 1;
			for(int i=0;i<N;i++) {
				pair tmp = pq.poll();
				//System.out.println(tmp.first+" "+tmp.second);
				v = (v*tmp.first+tmp.second)%1000000007;
			}
			System.out.println("#"+tc+" "+v);
		}
	}
}
