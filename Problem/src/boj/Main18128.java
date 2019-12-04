package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18128 {
	static final int dx[] = {0,1,0,-1,1,1,-1,-1};
	static final int dy[] = {-1,0,1,0,-1,1,1,-1};
	static int N, W;
	static int map[][];
	static int watermap[][];
	static boolean is_visit[][];
	static Queue<dot> q = new LinkedList<dot>();
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
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		watermap = new int[N][N];
		is_visit = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				watermap[i][j] = 987654321;
			}
		}
		for(int i=0;i<W;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			q.add(new dot(x, y));
			watermap[y][x] = 0;
		}
		int time = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {				
				int y = q.peek().y;
				int x = q.poll().x;
				for(int i=0;i<4;i++) {
					int xx = x+dx[i];
					int yy = y+dy[i];
					if(is_map(xx, yy) && watermap[yy][xx] ==987654321) {
						watermap[yy][xx] = time;
						q.add(new dot(xx, yy));
					}
				}
			}	
			time++;
		}
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<N;j++) {				
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		int left = 0;
		int right = time+1;
		//System.out.println(time);
		int ans = -1;
		while(left <= right) {
			int mid = (left+right)/2;
			//System.out.println(mid);
			is_visit = new boolean[N][N];
			time = 1;
			q = new LinkedList<>();
			q.add(new dot(0, 0));
			is_visit[0][0] = true;
			boolean is_end = false;
			end:while(!q.isEmpty()) {
				int size = q.size();
				for(int s=0;s<size;s++) {				
					int y = q.peek().y;
					int x = q.poll().x;
					for(int i=0;i<8;i++) {
						int xx = x+dx[i];
						int yy = y+dy[i];
						if(xx == N-1 && yy == N-1) {
							is_end = true;
							break end;
						}
						if(is_map(xx, yy) && map[yy][xx]==1 && !is_visit[yy][xx] && watermap[yy][xx] <= mid) {							
							is_visit[yy][xx] = true;
							q.add(new dot(xx, yy));
							
						}
					}
				}
			}
			if(is_end) {
				right=mid-1;
				ans = mid;
			}else {
				left = mid+1;
			}
			
			
		}
		/*for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(watermap[i][j]);
			}System.out.println();
		}*/
		
		System.out.println(ans);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=N) return false;
		return true;
	}
}
