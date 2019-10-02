package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10026 {
	static final int[] dx = {0,-1,1,0};
	static final int[] dy = {-1,0,0,1};
	
	static char[][] map;
	static int N;
	static boolean[][] is_visit, is_visitRG;
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		is_visit = new boolean[N][N];
		is_visitRG = new boolean[N][N];
		
		for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
		int rgb = 0, rg = 0;
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!is_visit[i][j]) {
					go(j, i, map[i][j], is_visit);
					rgb++;
				}
				if(!is_visitRG[i][j]) {
					if(map[i][j] == 'B') go(j, i, 'B', is_visitRG);
					else {
						goRG(j, i, 'R', is_visitRG);
					}
					rg++;
				}
			}
		}
		System.out.println(rgb + " " + rg);
		
	}
	
	static void go(int x, int y, char color, boolean[][] visit) {
		for(int i=0;i<4;i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if( is_map(xx, yy) && !visit[yy][xx] && map[yy][xx]==color ) {
				visit[yy][xx] = true;
				go(xx, yy, color, visit);
			}
		}
	}
	static void goRG(int x, int y, char color, boolean[][] visit) {
		for(int i=0;i<4;i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if( is_map(xx, yy) && !visit[yy][xx] && (map[yy][xx]=='R' || map[yy][xx] == 'G' ) ) {
				visit[yy][xx] = true;
				goRG(xx, yy, color, visit);
			}
		}
	}
	
	static boolean is_map(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N) return false;
		return true;
	}
}
