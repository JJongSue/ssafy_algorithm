package 삼성상시.day191118;

import java.util.Scanner;

public class Solution2 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	
	static int [][] cmap, amap, pmap;
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			
			cmap = new int[N][N];
			amap = new int[N][N];
			pmap = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					cmap[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					amap[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					pmap[i][j] = sc.nextInt();
				}
			}
			
			
			
		}
		
	}
	
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=N || y>= N) return false;
		return true;
	}
	
	
	static void game() {
		
		while(true) {
			int last = -1;
			boolean is_end = true;
			end: for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(cmap[i][j] != 0 && last == -1) {
						last = cmap[i][j];
					}else if(cmap[i][j] != 0 && last != -1 && cmap[i][j] != last) {
						is_end = false;
						break end;
					}
				}				
			}
			if(is_end) break;
			
			
			
			
			
		}
		
	}
	
	static void attack(int c) {
		int tmpmap[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				tmpmap[i][j] = amap[i][j];
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cmap[i][j] != c && tmpmap[i][j] != 0) {
					int sum = 0;
					int fsum = 0;
					for(int s=0;s<4;s++) {
						int xx = j + dx[s];
						int yy = i + dy[s];
						if(is_map(xx, yy) && cmap[yy][xx]==c) {
							sum += tmpmap[yy][xx];
							fsum += (tmpmap[yy][xx]/4);
						}
					}
					if(tmpmap[i][j]*5 < sum) {
						amap[i][j] -= fsum;
					}
					
				}
			}
		}
	}
	static void ji(int c) {
		
	}
	static void plus() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
