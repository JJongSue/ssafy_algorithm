package boj;

import java.util.Scanner;

public class Main17492 {
	static final int dx[] = {-1,0,1,-1,0,1,-1,0,1};
	static final int dy[] = {-1,-1,-1,0,0,0,1,1,1};
	static int map[][];
	static int N;
	static boolean is_posible = false;
	static int total_cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==2) total_cnt++;
			}
		}
		game(1, 1, total_cnt);
		if(is_posible) System.out.println("Possible");
		else System.out.println("Impossible");
		
		
		
		
	}
	static void game(int x, int y, int cnt) {
		if(cnt == 1) {
			is_posible = true;
			return;
		}
		if(y == N-1) return;
		if(is_posible) return;
		//System.out.println("N : "+N+"x : " + x + " y : "+y + " cnt : "+cnt);
		if(map[y][x] == 2) {
			for(int i=0;i<9;i++) {
				int xx = x+dx[i];
				int yy = y+dy[i];
				if(map[yy][xx] == 2) {
					if(map[yy+dy[i]][xx+dx[i]] == 0) {
						map[y][x] = 0;
						map[yy][xx] = 0;
						map[yy+dy[i]][xx+dx[i]] = 2;
						game(1, 1, cnt-1);
						
						map[y][x] = 2;
						map[yy][xx] = 2;
						map[yy+dy[i]][xx+dx[i]] = 0;
					}
					
				}
				
			}			
		}
		if(x == N-2) {
			game(1, y+1, cnt);
		}else {
			game(x+1, y, cnt);
		}
		
		
	}
	
	
	
}
