package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2583 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static boolean is_visit[][];
	static int N, M;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		is_visit = new boolean[N][M];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			for(int x=sx;x<ex;x++) {
				for(int y=sy;y<ey;y++) {
					is_visit[y][x] = true;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(is_visit[i][j]) continue;
				Queue<pair> q = new LinkedList<pair>();
				is_visit[i][j] = true;
				q.add(new pair(j,i));
				int size = 1;
				while(!q.isEmpty()) {
					int x = q.peek().x;
					int y = q.poll().y;
					for(int s=0;s<4;s++) {
						int xx = x+dx[s];
						int yy = y+dy[s];
						if(is_map(xx, yy) && !is_visit[yy][xx]) {
							is_visit[yy][xx] = true;
							size++;
							q.add(new pair(xx,yy));
						}
					}
				}
				
				pq.add(size);
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.print(pq.poll()+" ");
		}
		
	}
	
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
}
