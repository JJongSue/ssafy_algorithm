package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main15683 {
	static int N, M;
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static class pair{
		int x;
		int y;
		public pair() {
			super();
			// TODO Auto-generated constructor stub
		}
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static boolean omap[][][][];
	static int len;
	static boolean vmap[][];
	static int ans = 987654321;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = N*M;
		int map[][] = new int[N][M];
		/*ArrayList<pair> one = new ArrayList<>();
		ArrayList<pair> two = new ArrayList<>();
		ArrayList<pair> three = new ArrayList<>();
		ArrayList<pair> four = new ArrayList<>();*/		
		Queue<pair> five = new LinkedList<pair>();
		Queue<pair> one = new LinkedList<pair>();
		Queue<pair> two = new LinkedList<pair>();
		Queue<pair> three = new LinkedList<pair>();
		Queue<pair> four = new LinkedList<pair>();
		
		vmap = new boolean[N][M];
		/*for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) vmap[i][j] = true;
		}*/
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] != 0) vmap[i][j] = true;
				if(map[i][j] == 1) one.add(new pair(j,i));
				if(map[i][j] == 2) two.add(new pair(j,i));
				if(map[i][j] == 3) three.add(new pair(j,i));
				if(map[i][j] == 4) four.add(new pair(j,i));
				if(map[i][j] == 5) five.add(new pair(j,i));
			}
		}
		while(!five.isEmpty()) {
			pair tmp = five.poll();
			int xx = tmp.x;
			int yy = tmp.y;
			for(int s=0;s<4;s++) {
				xx = tmp.x;
				yy = tmp.y;
				while(true) {
					xx += dx[s];
					yy += dy[s];
					if(is_map(xx, yy) && map[yy][xx] != 6) {
						vmap[yy][xx] = true;
					}else break;					
				}
			}
		}
		len = one.size()+two.size()+three.size()+four.size();
		omap = new boolean[N][M][len][4];
		
		int iter = 0;
		while(!one.isEmpty()) {
			pair tmp = one.poll();
			int xx = tmp.x;
			int yy = tmp.y;
			for(int s=0;s<4;s++) {
				xx = tmp.x;
				yy = tmp.y;
				while(true) {
					xx += dx[s];
					yy += dy[s];
					if(is_map(xx, yy) && map[yy][xx] != 6) {
						omap[yy][xx][iter][s] = true;
					}else break;					
				}
			}
			iter++;
		}
		while(!two.isEmpty()) {
			pair tmp = two.poll();
			int xx = tmp.x;
			int yy = tmp.y;
			xx = tmp.x;
			yy = tmp.y;
			while(true) {
				xx += dx[0];
				yy += dy[0];
				if(is_map(xx, yy) && map[yy][xx] != 6) {
					omap[yy][xx][iter][0] = true;
					omap[yy][xx][iter][2] = true;
				}else break;					
			}
			
			xx = tmp.x;
			yy = tmp.y;
			while(true) {
				xx += dx[2];
				yy += dy[2];
				if(is_map(xx, yy) && map[yy][xx] != 6) {
					omap[yy][xx][iter][0] = true;
					omap[yy][xx][iter][2] = true;
				}else break;					
			}
			
			xx = tmp.x;
			yy = tmp.y;
			while(true) {
				xx += dx[1];
				yy += dy[1];
				if(is_map(xx, yy) && map[yy][xx] != 6) {
					omap[yy][xx][iter][1] = true;
					omap[yy][xx][iter][3] = true;
				}else break;					
			}
			
			xx = tmp.x;
			yy = tmp.y;
			while(true) {
				xx += dx[3];
				yy += dy[3];
				if(is_map(xx, yy) && map[yy][xx] != 6) {
					omap[yy][xx][iter][1] = true;
					omap[yy][xx][iter][3] = true;
				}else break;					
			}
			
			
			iter++;
		}
		
		while(!three.isEmpty()) {
			pair tmp = three.poll();
			int xx = tmp.x;
			int yy = tmp.y;
			for(int s=0;s<4;s++) {
				xx = tmp.x;
				yy = tmp.y;
				while(true) {
					xx += dx[s];
					yy += dy[s];
					if(is_map(xx, yy) && map[yy][xx] != 6) {
						omap[yy][xx][iter][s] = true;
					}else break;					
				}
				xx = tmp.x;
				yy = tmp.y;
				while(true) {
					xx += dx[(s+1)%4];
					yy += dy[(s+1)%4];
					if(is_map(xx, yy) && map[yy][xx] != 6) {
						omap[yy][xx][iter][s] = true;
					}else break;					
				}
			}
			iter++;
		}
		
		
		while(!four.isEmpty()) {
			pair tmp = four.poll();
			int xx = tmp.x;
			int yy = tmp.y;
			for(int s=0;s<4;s++) {
				xx = tmp.x;
				yy = tmp.y;
				while(true) {
					xx += dx[s];
					yy += dy[s];
					if(is_map(xx, yy) && map[yy][xx] != 6) {
						omap[yy][xx][iter][s] = true;
					}else break;					
				}
				xx = tmp.x;
				yy = tmp.y;
				while(true) {
					xx += dx[(s+1)%4];
					yy += dy[(s+1)%4];
					if(is_map(xx, yy) && map[yy][xx] != 6) {
						omap[yy][xx][iter][s] = true;
					}else break;					
				}
				xx = tmp.x;
				yy = tmp.y;
				while(true) {
					xx += dx[(s+2)%4];
					yy += dy[(s+2)%4];
					if(is_map(xx, yy) && map[yy][xx] != 6) {
						omap[yy][xx][iter][s] = true;
					}else break;					
				}
			}
			iter++;
		}
		comb(0, new int[len+1]);
		System.out.println(ans);
		
		
		
		
		
		
		
	}
	static void comb(int now, int arr[]) {
		if(now == len) {
			boolean tmpmap[][] = new boolean[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					tmpmap[i][j] = vmap[i][j];
				}					
			}
			for(int s=0;s<len;s++) {
				//System.out.print(arr[s]+" ");
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						tmpmap[i][j] = tmpmap[i][j]|omap[i][j][s][arr[s]];
					}					
				}
			}
			//System.out.println();
			int tmpcnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!tmpmap[i][j]) tmpcnt++;
				}					
			}
			ans = Math.min(tmpcnt, ans);
			return;
		}
		arr[now]=0;
		comb(now+1, arr);
		arr[now]=1;
		comb(now+1, arr);
		arr[now]=2;
		comb(now+1, arr);
		arr[now]=3;
		comb(now+1, arr);
		
	}
	
	static boolean is_map(int x, int y) {
		if(x <0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
	
}
