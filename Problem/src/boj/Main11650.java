package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main11650 {
	static PriorityQueue<dot> pq = new PriorityQueue<dot>();
	static class dot implements Comparable<dot>{
		int x;
		int y;
		public dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(dot o) {
			if(this.x == o.x) {
				return this.y-o.y;
			}
			return this.x-o.x;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new dot(x, y));
			
		}
		while(!pq.isEmpty()){
			sb.append(pq.peek().x).append(" ").append(pq.poll().y).append("\n");
		}
		System.out.println(sb);
	}
}
