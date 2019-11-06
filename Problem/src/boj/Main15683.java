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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int map[][] = new int[N][M];
		ArrayList<pair> one = new ArrayList<>();
		ArrayList<pair> two = new ArrayList<>();
		ArrayList<pair> three = new ArrayList<>();
		ArrayList<pair> four = new ArrayList<>();		
		Queue<pair> five = new LinkedList<pair>();
		boolean vmap[][] = new boolean[N][M];
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
				while(true) {
					xx += dx[s];
					yy += dy[s];
					if(is_map(xx, yy) && map[yy][xx] != 6) {
						vmap[yy][xx] = true;
					}else break;					
				}
			}
		}
		
		
		
		
		
		
	}
	static boolean is_map(int x, int y) {
		if(x <0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
	
}
