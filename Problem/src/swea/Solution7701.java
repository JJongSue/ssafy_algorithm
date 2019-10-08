package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution7701 {
	static class name implements Comparable<name>{
		String n;

		@Override
		public int compareTo(name o) {
			if(this.n.length() == o.n.length()) {
				return this.n.compareTo(o.n);
			}
			return this.n.length()-o.n.length();
		}

		public name(String n) {
			super();
			this.n = n;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<name> pq = new PriorityQueue<>();
			for(int i=0;i<N;i++) {
				pq.add(new name(br.readLine()));
			}
			sb.append("#").append(tc).append("\n");
			String tmp = " ";
			while(!pq.isEmpty()) {
				if(tmp.equals(pq.peek().n)) {
					pq.poll();
					continue;
				}
				tmp = pq.peek().n;
				pq.poll();
				sb.append(tmp).append("\n");
				
			}
		}
		System.out.println(sb);
	}
}
