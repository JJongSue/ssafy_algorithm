package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1937 {
	static final int dx[] = {0,-1,1,0};
	static final int dy[] = {-1,0,0,1};
	static int N;
	static boolean is_visit[][];
	static int map[][];
	static int dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		map = new int[N][N];
		is_visit = new boolean[N][N];
		dp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], -1);
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) max = Math.max(max, go(j,i));
				
		}
		System.out.println(max+1);
		
		
		
		
	}
	static int go(int x, int y) {
		if(dp[y][x] != -1) return dp[y][x];
		boolean is_go = false;
		int min = 0;
		for(int i=0;i<4;i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(is_map(xx, yy) && map[yy][xx] > map[y][x]) {
				min = Math.max(min, go(xx,yy));				
				is_go=true;
			}
		}
		if(!is_go) return dp[y][x] =0;
		else return dp[y][x]=min+1;		
	}
	
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=N) return false;
		return true;
	}
}
