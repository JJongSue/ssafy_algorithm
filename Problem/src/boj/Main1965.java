package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1965 {
	static class max_num implements Comparable<max_num>{
		int x;
		int cnt;
		public max_num(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(max_num o) {
			if(o.cnt == this.cnt) {
				return this.cnt - o.cnt;
			}
			return o.cnt - this.cnt;
		}
	}
	static PriorityQueue<max_num> pq = new PriorityQueue<max_num>();
	static int min_num = 1001;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(st.nextToken());
			if(input < min_num) {
				min_num = input;
				pq.add(new max_num(input, 1));
				continue;
			}
//			if(!pq.isEmpty()) {
//				pq.add(new max_num(input, 1));
//				min_num = input;
//				continue;
//			}
			
			Queue<max_num> q = new LinkedList<max_num>();
			
			while(!pq.isEmpty()) {
				if(pq.peek().x < input) {
					pq.add(new max_num(input, pq.peek().cnt+1));
					break;
				}
				if(pq.peek().x == input) break;
				q.add(pq.poll());
				
				
			}
			while(!q.isEmpty()) pq.add(q.poll());
			
			
			
		}
		while(!pq.isEmpty()) {
			System.out.println(pq.peek().x + " " + pq.peek().cnt);
			pq.poll();
		}
		//System.out.println(pq.peek().cnt);
	}
	
}
