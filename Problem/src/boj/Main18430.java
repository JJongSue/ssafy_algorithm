package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18430 {
	static int dx[][] = {{-1,0},{-1,0},{1,0},{1,0}};
	static int dy[][] = {{0,1},{0,-1},{0,-1},{0,1}};
	static int N, M;
	static int map[][];
	static int sum = 0, ans = 0;
	static boolean is_visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		is_visit = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		
		if(N == 1 || M == 1) {
			System.out.println(0);
		}else {
			make(0);
			System.out.println(ans);
		}
	}
	static void make(int now) {
		if(now == N*M) {
			ans = Math.max(ans, sum);
			return;
		}
		make(now+1);
		int x = now%M;
		int y = now/M;
		if(is_visit[y][x]) return;
		for(int i=0;i<4;i++) {
			//System.out.println(x+" "+y);
			if(x+dx[i][0] >= 0 && x+dx[i][0]<M && y+dy[i][1] >= 0 && y+dy[i][1] < N) {
				if(is_visit[y+dy[i][0]][x+dx[i][0]] || is_visit[y+dy[i][1]][x+dx[i][1]]) continue;
				
				sum += map[y][x]*2+map[y+dy[i][0]][x+dx[i][0]]+map[y+dy[i][1]][x+dx[i][1]];
				is_visit[y+dy[i][0]][x+dx[i][0]] = true; 
				is_visit[y+dy[i][1]][x+dx[i][1]] = true;
				is_visit[y][x] = true;
				make(now+1);
				sum -= map[y][x]*2+map[y+dy[i][0]][x+dx[i][0]]+map[y+dy[i][1]][x+dx[i][1]];
				is_visit[y+dy[i][0]][x+dx[i][0]] = false; 
				is_visit[y+dy[i][1]][x+dx[i][1]] = false;
				is_visit[y][x] = false;
			}
		}
	}
	
	
}
