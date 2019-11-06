package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1733 {
	static final int dx[] = {1,1,0,1};
	static final int dy[] = {0,1,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int map[][] = new int[19][19];
		StringTokenizer st;
		boolean is_visit[][][][] = new boolean[19][19][4][2];
		for(int i=0;i<19;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<19;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		int ansx = -1;
		int ansy = -1;
		int win = -1;
		end: for(int i=0;i<19;i++) {			
			for(int j=0;j<19;j++) {
				if(map[i][j] == 1) {
					int cnt = 1;
					if(!is_visit[i][j][0][0]) {						
						for(int x=j+1;x<19;x++) {
							if(is_map(x, i) && map[i][x] == 1) {
								is_visit[i][x][0][0] = true;
								cnt++;
							}else break;
						}
						if(cnt == 5) {
							win = 1;
							ansx = j;
							ansy = i;
							break end;
						}
					}
					cnt=1;
					if(!is_visit[i][j][1][0]) {
						for(int x=j+1;x<19;x++) {
							if(is_map(x, i+x-j) && map[i+x-j][x] == 1) {
								is_visit[i+x-j][x][1][0] = true;
								cnt++;
							}else break;
						}
						if(cnt == 5) {
							win = 1;
							ansx = j;
							ansy = i;
							break end;
						}
					}
					cnt=1;
					if(!is_visit[i][j][2][0]) {
						for(int y=i+1;y<19;y++) {
							if(is_map(j, y) && map[y][j] == 1) {
								is_visit[y][j][2][0] = true;
								cnt++;
							}else break;
						}
						if(cnt == 5) {
							win = 1;
							ansx = j;
							ansy = i;
							break end;
						}
					}
					
				}
				if(map[i][j] == 2) {
					int cnt = 1;
					if(!is_visit[i][j][0][1]) {						
						for(int x=j+1;x<19;x++) {
							if(is_map(x, i) && map[i][x] == 2) {
								is_visit[i][x][0][1] = true;
								cnt++;
							}else break;
						}
						if(cnt == 5) {
							win = 2;
							ansx = j;
							ansy = i;
							break end;
						}
					}
					cnt=1;
					if(!is_visit[i][j][1][1]) {
						for(int x=j+1;x<19;x++) {
							if(is_map(x, i+x-j) && map[i+x-j][x] == 2) {
								is_visit[i+x-j][x][1][1] = true;
								cnt++;
							}else break;
						}
						if(cnt == 5) {
							win = 2;
							ansx = j;
							ansy = i;
							break end;
						}
					}
					cnt=1;
					if(!is_visit[i][j][2][1]) {
						for(int y=i+1;y<19;y++) {
							if(is_map(j, y) && map[y][j] == 2) {
								is_visit[y][j][2][1] = true;
								cnt++;
							}else break;
						}
						if(cnt == 5) {
							win = 2;
							ansx = j;
							ansy = i;
							break end;
						}
					}
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		}
		end:for(int i=18;i>=0;i--) {
			for(int j=18;j>=0;j--) {
				if(win != -1) break end;
				int cnt=1;
				if(map[i][j] == 1 && !is_visit[i][j][3][0]) {
					for(int x=j+1;x<19;x++) {
						if(is_map(x, i-x+j) && map[i-x+j][x] == 1) {
							is_visit[i-x+j][x][3][0] = true;
							cnt++;
						}else break;
					}
					if(cnt == 5) {
						win = 1;
						ansx = j;
						ansy = i;
						break end;
					}
				}
				cnt=1;
				if(map[i][j] == 2 && !is_visit[i][j][3][1]) {
					for(int x=j+1;x<19;x++) {
						if(is_map(x, i-x+j) && map[i-x+j][x] == 2) {
							is_visit[i-x+j][x][3][1] = true;
							cnt++;
						}else break;
					}
					if(cnt == 5) {
						win = 2;
						ansx = j;
						ansy = i;
						break end;
					}
				}
			}
		}
		
		
		
		if(win == -1) System.out.println(0);
		else {
			System.out.println(win);
			System.out.println((ansy+1)+" "+(ansx+1));
		}
		
		
	}
	
	static boolean is_map(int x, int y) {
		if(x>=19 || y>=19 || y<0 || x<0) return false;
		return true;
	}
}
