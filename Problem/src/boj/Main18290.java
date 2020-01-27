package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18290 {
	static final int dx[] = {-1, 0};
	static final int dy[] = {0, -1};
	
	static int map[][];
	static boolean is_visit[][];
	static int N, M, K;
	static int ans = Integer.MIN_VALUE;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		is_visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for(int i=0;i<N*M;i++) {
//			int x = i%N;
//			int y = i/N;
//			int sum = map[y][x];
//			
//			if(K == 1) {
//				ans = Math.max(sum, ans);
//				continue;
//			}
//			for(int j=i+1;j<N*M;j++) {
//				x = j%N;
//				y = j/N;
//				boolean is_ok = true;
//				for(int ds=0;ds<2;ds++) {
//					int xx = x+dx[i];
//					int yy = y+dy[i];
//					if(is_go(xx, yy) && is_visit[yy][xx]) {
//						is_ok=false;
//					}
//				}
//				if(!is_ok) continue;
//				sum += map[y][x];
//				if(K == 2) {
//					ans = Math.max(sum, ans);
//					sum -= map[j/N][j%N];
//					continue;
//				}
//				for(int k=j+1;k<N*M;k++) {
//					
//					for(int l=k+1;l<N*M;l++) {
//						
//					}
//				}
//				sum -= map[j/N][j%N];
//			}
//			
//			ans = Math.max(sum, ans);
//		}
		
		
		find_num(0, 0, 0);
		System.out.println(ans);
//		for(int i=0;i<N*M;i++) {
//			find_num(i, 0, 0);
//		}
		
	}
	
	static boolean is_go(int x, int y) {
		if(x < 0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
	
	static void find_num(int now, int cnt, int sum) {
		if(cnt == K) {
			ans = Math.max(ans, sum);
			return;
		}
		if(now >= N*M) return;
		boolean is_ok = true;
		
		for(int i=0;i<2;i++) {
			if(is_go(now%N+dx[i], now/N+dy[i]) && is_visit[now/N+dy[i]][now%N+dx[i]]) {
				is_ok=false;
			}
		}
		if(is_ok) {
			is_visit[now/N][now%N] = true;
			find_num(now+2, cnt+1, sum+map[now/N][now%N]);
			is_visit[now/N][now%N] = false;			
		}
		find_num(now+1, cnt, sum);
	}
}
