package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2234 {
	static final int dx[] = {-1,0,1,0};
	static final int dy[] = {0,-1,0,1};
	static int N, M;
	static int firstmap[][];
	static int nums[][], dis[][];
	static Queue<dot> q;
	static int rcnt[] = new int[5000];
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		nums = new int[N][M];
		dis = new int[N][M];
		firstmap = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				firstmap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int now = 1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(nums[i][j] == 0) {
					bfs(now, j, i);
					now++;
				}
			}
		}
		System.out.println(now-1);
		int max = 0;
		for(int i=0;i<now;i++) {
			max = Math.max(max, rcnt[i]);
		}
		System.out.println(max);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int wall = firstmap[i][j];
				for(int s=0;s<4;s++) {
					if( ((wall>>s) & 1) == 1 ) {
						int xx = j+dx[s];
						int yy = i+dy[s];
						if(is_map(xx, yy) && nums[yy][xx] != nums[i][j]) {
							max = Math.max(max, rcnt[nums[yy][xx]] + rcnt[nums[i][j]]);
						}
					}
				}
			}
		}
		System.out.println(max);
		
		
	}
	
	static void bfs(int now, int x, int y) {
		q = new LinkedList<dot>();
		nums[y][x] = now;
		rcnt[now]++;
		q.add(new dot(x, y));
		while(!q.isEmpty()) {
			int nx = q.peek().x;
			int ny = q.poll().y;
			int wall = firstmap[ny][nx];
			for(int s=0;s<4;s++) {
				if( ((wall>>s) & 1) == 0 ) {
					int xx = nx+dx[s];
					int yy = ny+dy[s];
					if(is_map(xx, yy) && nums[yy][xx] == 0) {
						q.add(new dot(xx, yy));
						nums[yy][xx] = now;
						rcnt[now]++;
					}
				}
			}
		}
	}
	
	
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
}
