package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10342 {
	static char [][]map;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			map = new char[N][M];
			for(int i=0;i<N;i++) {
				map[i] = br.readLine().toCharArray();
			}
			int s_x = -1, s_y=-1;
			for(int i=0;i<N;i++) {
				if(map[i][0] == '*') {
					s_x = 0;
					s_y = i;
					go_right(1, i);
					
					break;
				}
				if(map[i][M-1] == '*') {
					s_x = M-1;
					s_y = i;
					go_left(M-2, i);
				}			
			}
			for(int i=0;i<M;i++) {
				if(map[0][i] == '*') {
					s_x = i;
					s_y = 0;
					go_down(i, 1);
				}
				if(map[N-1][i] == '*') {
					s_x = i;
					s_y = N-1;
					go_up(i, N-2);
				}			
			}
			System.out.println("HOUSE "+cnt);
			cnt++;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.print(map[i][j]);
				}System.out.println();
				
			}
		}
		
		
		
	}
	static void go_right(int x, int y) {
		if(map[y][x] == 'x') {
			map[y][x] = '&';
			return;
		}
		if(map[y][x] == '.') {
			go_right(x+1, y);
			return;
		}
		if(map[y][x] == '/') {
			go_up(x,y-1);
			return;
		}
		else {
			go_down(x,y+1);
			return;
		}
	}
	static void go_up(int x, int y) {
		if(map[y][x] == 'x') {
			map[y][x] = '&';
			return;
		}
		if(map[y][x] == '.') {
			go_up(x, y-1);
			return;
		}
		if(map[y][x] == '/') {
			go_right(x+1,y);
			return;
		}
		else {
			go_left(x-1,y);
			return;
		}
		
	}
	static void go_down(int x, int y) {
		if(map[y][x] == 'x') {
			map[y][x] = '&';
			return;
		}
		if(map[y][x] == '.') {
			go_down(x, y+1);
			return;
		}
		if(map[y][x] == '/') {
			go_left(x-1,y);			
			return;
		}
		else {
			go_right(x+1,y);
			return;
		}
	}
	static void go_left(int x, int y) {
		if(map[y][x] == 'x') {
			map[y][x] = '&';
			return;
		}
		if(map[y][x] == '.') {
			go_left(x-1, y);
			return;
		}
		if(map[y][x] == '/') {
			go_down(x,y+1);
			return;
		}
		else {
			go_up(x,y-1);			
			return;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
