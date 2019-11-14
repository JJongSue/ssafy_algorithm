package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2423 {
	//아래 대각, 위대각, 아래 왼대각
	static int dx[] = {1,1,-1,-1};
	static int dy[] = {1,-1,1,-1};
	
	static int N, M;
	static int dp[][];
	static char map[][];
	static boolean is_visit[][];
	static Queue<pair> q;
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
		System.setIn(new FileInputStream("test.dat"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dp = new int[N+1][M+1];
		for(int i=0;i<N+1;i++) {
			for(int j=0;j<M+1;j++) {
				dp[i][j] = 987654321;
			}
		}
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}		
//		System.out.println(map[0][0]);
		dp[0][0] = 0;
		if(map[0][0] == '/') dp[1][1] = 1;
		else dp[1][1] = 0;
		q = new LinkedList<pair>();
		is_visit = new boolean[N+1][M+1];
		is_visit[1][1]=true;
		q.add(new pair(1,1));
		while(!q.isEmpty()) {
			if((N+M)%2 ==1) break;
			int x = q.peek().x;
			int y = q.poll().y;
			is_visit[y][x] = false;
			//System.out.println(x+" "+y);
			for(int s=0;s<4;s++) {
				int xx =x+dx[s];
				int yy = y+dy[s];
				if(is_map(xx,yy)) {
					if(s==0) {
						int tmp = dp[y][x];
						if(map[y][x] == '/') tmp++;
						if(dp[yy][xx] > tmp) {
							dp[yy][xx] = tmp;
							if(!is_visit[yy][xx]) {
								q.add(new pair(xx,yy));
								is_visit[yy][xx]= true;								
							}

						}
					}else if(s==1) {
						int tmp = dp[y][x];
						if(map[y-1][x] == '\\') tmp++;
						if(dp[yy][xx] > tmp) {
							dp[yy][xx] = tmp;
							if(!is_visit[yy][xx]) {
								q.add(new pair(xx,yy));
								is_visit[yy][xx]= true;								
							}
						}
					}else if(s==2) {
						int tmp = dp[y][x];
						if(map[y][x-1] == '\\') tmp++;
						if(dp[yy][xx] > tmp) {
							dp[yy][xx] = tmp;
							if(!is_visit[yy][xx]) {
								q.add(new pair(xx,yy));
								is_visit[yy][xx]= true;								
							}
						}
					}else if(s==3) {
						int tmp = dp[y][x];
						if(map[y-1][x-1] == '/') tmp++;
						if(dp[yy][xx] > tmp) {
							dp[yy][xx] = tmp;
							if(!is_visit[yy][xx]) {
								q.add(new pair(xx,yy));
								is_visit[yy][xx]= true;								
							}
						}
					}
				}
			}
		}
		if(dp[N][M] == 987654321) System.out.println("NO SOLUTION");
		else System.out.println(dp[N][M]);
		
		
		
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>M || y>N) return false;
		return true;
	}
}
