package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2406 {
	static PriorityQueue<line> pq = new PriorityQueue<line>();
	static int parents[];
	static Queue<ansline> q = new LinkedList<ansline>();
	static class ansline{
		int x;
		int y;
		public ansline(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int find_set(int x) {
		if(parents[x] < 0) return x;
		return parents[x] = find_set(parents[x]);
	}
	static void union(int x, int y) {
		int px = find_set(x);
		int py = find_set(y);
		parents[px] += parents[py];
		parents[py] = px;
	}
	
	static class line implements Comparable<line>{
		int x;
		int y;
		int dis;
		public line(int x, int y, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
		@Override
		public int compareTo(line o) {
			// TODO Auto-generated method stub
			return this.dis-o.dis;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			parents[i] = -1;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int tmpx = Integer.parseInt(st.nextToken());
			int tmpy = Integer.parseInt(st.nextToken());
			
			int px = find_set(tmpx);
			int py = find_set(tmpy);
			if(px != py) {
				union(tmpx, tmpy);
			}
			
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			if(i==1) continue;
			for(int j=1;j<=N;j++) {
				int dis = Integer.parseInt(st.nextToken());
				if(i>j) continue;
				pq.add(new line(i, j, dis));
				
			}
		}
		long ans = 0;
		int linecnt = 0;
		while(!pq.isEmpty()) {
			int cnt = 0;
			for(int i=2;i<=N;i++) {
				if(parents[i]<0) cnt++;
				if(cnt>1) break;
			}
			if(cnt == 1) break;
			int x = pq.peek().x;
			int y = pq.peek().y;
			int dis = pq.poll().dis;
			
			int px = find_set(x);
			int py = find_set(y);
			if(px != py) {
				union(x, y);
				ans += dis;
				linecnt++;
				q.add(new ansline(x, y));
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append(" ").append(linecnt).append("\n");
		while(!q.isEmpty()) {
			sb.append(q.peek().x).append(" ").append(q.poll().y).append("\n");
		}
		System.out.println(sb);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
