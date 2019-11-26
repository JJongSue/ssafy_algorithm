package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main17939 {
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
			// TODO Auto-generated method stub
			return this.num-o.num;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long ans = 0;
		PriorityQueue<pair> pq = new PriorityQueue<>();		
		pq.add(new pair(arr[0], 1));
		for(int i=1;i<N;i++) {			
			int cnt = 1;
			while(!pq.isEmpty() && pq.peek().num<arr[i]) {
				int tmpn = pq.peek().num;
				int tmpc = pq.poll().cnt;
				ans += ((arr[i]-tmpn)*tmpc);	
				cnt += tmpc;
			}
			pq.add(new pair(arr[i], cnt));
		}
		System.out.println(ans);
	}
}
