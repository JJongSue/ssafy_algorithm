package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2573 {
	static final int dx[] = {0,-1,1,0};
	static final int dy[] = {-1,0,0,1};
	
	static int map[][], island[][], minus[][];
	static int N, M;
	static int cnt, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		max = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j]) max = map[i][j];				
			}
		}
		if(max == 0 ) {
			System.out.println(0);
		}else {
			boolean zero =true;
			int i=0;
			while(true) {
				zero =true;
				minus = new int[N][M];
				island = new int[N][M];
				cnt = 1;
				for(int j=0;j<N;j++) {
					for(int k=0;k<M;k++) {
						if( island[j][k] == 0 && map[j][k] > 0) {
							island[j][k] = cnt;
							bfs(0, k, j);
							cnt++;
						}
						
					}
				}
				for(int j=0;j<N;j++) {
					for(int k=0;k<M;k++) {
						map[j][k]-=minus[j][k];					
					}
				}
				/*for(int j=0;j<N;j++) {
					System.out.println(Arrays.toString(map[j]));
				}*/
				if(cnt >= 3) {
					/*for(int j=0;j<N;j++) {
						System.out.println(Arrays.toString(island[j]));
					}*/
					System.out.println(i);
					zero =false;
					break;
				}
				if(cnt == 1) break;
				i++;
			}
			
			if(zero) System.out.println(0);
			
			
			
		}
	}
	static void bfs(int div, int x, int y) {
		for(int i=0;i<4;i++) {
			int xx =  x+dx[i];
			int yy = y+dy[i];
			if(is_map(xx, yy) && island[yy][xx] == 0 && map[yy][xx] > div) {
				island[yy][xx] =cnt;
				
				bfs(div, xx, yy);
				
			}
			else if(is_map(xx, yy) &&  map[yy][xx] <= 0) {
				minus[y][x]++;
			}
		}
	}
	static boolean is_map(int x, int y) {
		if( x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
}
