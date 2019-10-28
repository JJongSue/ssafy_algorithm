package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2105 {
	static final int dx[] = {-1,1,1,-1};
	static final int dy[] = {1,1,-1,-1};
	static int ans = -1;
	static int map[][];
	static boolean what_desert[];
	static int N;
	static int t1, t2;
	static boolean is_ans = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			ans = -1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			what_desert = new boolean[101];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<N-1;i++) {
				for(int j=1;j<N-1;j++) {
					go(j, i, -1, -1, 0, 0);
					System.out.println();
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		
		
	}
	static boolean is_map(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N) return false;
		return true;
	}
	
	static void go(int x, int y, int s_x, int s_y, int d, int cnt) {
		is_ans = false;
		if(s_x == -1 ) {
			s_x = x;
			s_y = y;
			int xx = x+dx[d];
			int yy = y+dy[d];
			what_desert[map[y][x]] = true;
			if(is_map(xx, yy)) {
				t1=0;
				t1++;
				go(xx, yy, s_x, s_y, d, cnt+1);
			}
			what_desert[map[y][x]] = false;
			return;
		}
		if(x == s_x && y == s_y) {
			if(cnt>ans) {
				is_ans = true;
				System.out.println(cnt+" y : " + y + " x : "+ x);
			}
			ans = Math.max(ans, cnt);
			
		}
		if(what_desert[map[y][x]]) return;
		what_desert[map[y][x]] = true;
		if(d == 0) {
			int xx = x+dx[d+1];
			int yy = y+dy[d+1];			
			if(is_map(xx, yy)) {
				t2 = 1;
				go(xx, yy, s_x, s_y, d+1, cnt+1);
			}
			xx = x+dx[d];
			yy = y+dy[d];			
			if(is_map(xx, yy)) {
				t1++;
				go(xx, yy, s_x, s_y, d, cnt+1);
			}		
			what_desert[map[y][x]] = false;
		}
		else if(d == 1) {
			int xx = x+dx[d+1];
			int yy = y+dy[d+1];			
			if(is_map(xx, yy)) {				
				go(xx, yy, s_x, s_y, d+1, cnt+1);
			}
			xx = x+dx[d];
			yy = y+dy[d];			
			if(is_map(xx, yy)) {
				t2++;
				go(xx, yy, s_x, s_y, d, cnt+1);
			}		
			what_desert[map[y][x]] = false;
		}else if(d == 2) {
			if(cnt-t2-t1 == t1) {
				int xx = x+dx[d+1];
				int yy = y+dy[d+1];			
				if(is_map(xx, yy)) {				
					go(xx, yy, s_x, s_y, d+1, cnt+1);
				}
			}else {
				int xx = x+dx[d];
				int yy = y+dy[d];			
				if(is_map(xx, yy)) {				
					go(xx, yy, s_x, s_y, d, cnt+1);
				}
			}				
			what_desert[map[y][x]] = false;
		}else if(d == 3) {
			int xx = x+dx[d];
			int yy = y+dy[d];			
			if(is_map(xx, yy)) {				
				go(xx, yy, s_x, s_y, d, cnt+1);
			}
			what_desert[map[y][x]] = false;
		}
		if(is_ans) System.out.print(map[y][x]+" ");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
