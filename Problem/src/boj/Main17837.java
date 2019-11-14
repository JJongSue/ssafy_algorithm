package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main17837 {
	static final int dx[] = {1,-1,0,0};
	static final int dy[] = {0,0,-1,1};
	
	static int N, K;
	static int map[][];
	static int movemap[][][];
	
	static class che{
		int x;
		int y;
		int r;
		public che(int x, int y, int r) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		movemap = new int[N][N][K];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ArrayList<che> al = new ArrayList<>();
		al.add(new che(0,0,0));
		for(int i=0;i<K;i++) {
			int y = sc.nextInt()-1;
			int x = sc.nextInt()-1;
			int r = sc.nextInt()-1;
			al.add(new che(x, y, r));
			movemap[y][x][0]=i+1;
		}
		int time = 0;
		end:while(time<=1000) {
			for(int s=1;s<K;s++) {
				int x = al.get(s).x;
				int y = al.get(s).y;
				int r = al.get(s).r;
				int start = -1;
				int end = K;
				for(int now = 0; now<K;now++) {
					if(s== movemap[y][x][now]) {
						start = now;						
					}
					if(movemap[y][x][now]==0) {
						end = now;
						break;
					}
				}
				int moving[] = new int[end-start];
				for(int i=start;i<end;i++) {
					moving[i-start] = movemap[y][x][i];					
				}
				int xx = x+dx[r];
				int yy = y+dy[r];
				if(xx<0 || yy<0 || xx>=N || yy>=N || map[yy][xx] == 2) {
					if(r==0 || r==2) al.get(s).r++;
					else al.get(s).r--;
					continue;
				}
				for(int i=0;i<moving.length;i++) {
					al.get(moving[i]).y = yy;
					al.get(moving[i]).x = xx;
				}
				if(map[yy][xx] == 0) {
					int iter = 0;
					for(iter = 0;iter<K;iter++) {
						if(movemap[yy][xx][iter] == 0) break;
					}
					for(int i=0;i<end-start;i++) {
						movemap[yy][xx][i+iter] = moving[i];
						if(i+iter >= 3) {
							break end;
						}
					}
					for(int i=start;i<end;i++) {
						movemap[y][x][i] = 0;
					}
					
					continue;
				}
				int iter = 0;
				for(iter = 0;iter<K;iter++) {
					if(movemap[yy][xx][iter] == 0) break;
				}
				int ii=0;
				for(int i=end-start-1;i>=0;i--) {
					movemap[yy][xx][ii+iter] = moving[i];
					if(ii+iter >= 3) {
						break end;
					}
					ii++;
				}
				for(int i=start;i<end;i++) {
					movemap[y][x][i] = 0;
				}
				
				
				
			}
			
			time++;
		}
		if(time > 1000) System.out.println(-1);
		else System.out.println(time);
		
		
		
		
	}
}
