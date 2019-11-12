package boj;

import java.util.Scanner;

public class Main15685 {
	static final int dx[] = {1,0,-1,0};
	static final int dy[] = {0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean map[][] = new boolean[101][101];
		for(int s=0;s<N;s++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			int tmp = 1;
			map[y][x] = true;
			end:while(true) {
				for(int i=0;i<tmp;i++) {
					if(g==-1) break end;
					g--;
					y=y+dy[d];
					x=x+dx[d];
					map[y][x] = true;
					d = (d+1)%4;
				}
				if(g==-1) break end;
				g--;
				y=y-dy[d];
				x=x-dx[d];
				map[y][x] = true;
				d = (d+1)%4;
				tmp++;
			}
			
		}
		int ans=0;
		for(int i=0;i<99;i++) {
			for(int j=0;j<99;j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
					ans++;
			}
		}
		System.out.println(ans);
		
	}
}
