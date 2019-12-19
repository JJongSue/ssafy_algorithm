package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12015 {
	static PriorityQueue<pair> pq = new PriorityQueue<>();
	static Queue<pair> q = new LinkedList<>();
	static boolean is_visit[];
	static class pair implements Comparable<pair>{
		int num;
		int cnt;
		public pair(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(pair o) {
			if(this.cnt == o.cnt) return o.num-this.num;
			return o.cnt-this.cnt;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		is_visit = new boolean[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			//System.out.println(tmp);
			if(!is_visit[tmp]) {
				is_visit[tmp] = true;
				boolean end = false;
				while(!pq.isEmpty()) {
					if(pq.peek().num < tmp) {
						pq.add(new pair(tmp, pq.peek().cnt+1));
						end = true;
						break;
					}else {
						q.add(pq.poll());
					}
				}
				if(!end) pq.add(new pair(tmp, 1));
				while(!q.isEmpty()) pq.add(q.poll());
			}
		}
		System.out.println(pq.peek().cnt);
		
	}

}
