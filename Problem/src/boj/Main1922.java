package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1922 {
	static int[] com;
	static int find_set(int x) {
		if(com[x] == x) return x;
		else return x=find_set(com[x]);
	}
	static void union(int x, int y)
	{
		int px = find_set(x);
		int py = find_set(y);
		if(px != py) com[py]=px;
	}
	static class network implements Comparable<network>{
		int x;
		int y;
		int price;
		public network(int x, int y, int price) {
			super();
			this.x = x;
			this.y = y;
			this.price = price;
		}
		@Override
		public int compareTo(network o) {
			// TODO Auto-generated method stub
			return this.price-o.price;
		}		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		com = new int[N+1];
		for(int i=1;i<N+1;i++) com[i]=i;
		PriorityQueue<network> pq = new PriorityQueue<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			if(x>y) pq.add(new network(y, x, price));
			else pq.add(new network(x, y, price));
			
		}
		int answer = 0;
		while(true)
		{
			network tmp = pq.poll();
			if(find_set(tmp.x) != find_set(tmp.y))
			{
				union(tmp.x, tmp.y);
				answer+=tmp.price;
			}			
			
			
			int netcnt=0;
			for(int i=1;i<N+1;i++) {
				if(com[i]==i) netcnt++;
				if(netcnt==2) break;
			}
			if(netcnt==1) break;
		}
		System.out.println(answer);
		
	}
}
