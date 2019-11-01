package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16509 {
	static final int dx[] = {3,3,2,-2,-3,-3,-2,2};
	static final int dy[] = {-2,2,3,3,2,-2,-3,-3};
	static int [][]map;
	static int ky, kx;
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public pair() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][9];
		int uy = sc.nextInt();
		int ux = sc.nextInt();
		ky = sc.nextInt();
		kx = sc.nextInt();
		map[uy][ux] = 1;
		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(ux, uy));
		int time = 1;
		while(!q.isEmpty()) {
			if(map[ky][kx] != 0) break;
			int size = q.size();
			for(int s=0;s<size;s++) {
				if(map[ky][kx] != 0) break;
				pair tmp = q.poll();
				for(int i=0;i<8;i++) {
					int xx = tmp.x+dx[i];
					int yy = tmp.y+dy[i];
					if(is_map(xx, yy) && map[yy][xx] == 0 && is_stone(tmp.x, tmp.y, i)) {
						
						//System.out.println(xx + " " + yy + " " +time);
						map[yy][xx] = time;
						q.add(new pair(xx,yy));
					}
				}
			}
			
			time++;
			
			
		}
		System.out.println(time == 0 ? -1 : map[ky][kx]);
		
	}
	static boolean is_map(int x, int y) {
		if(x < 0 || y < 0 || x>8 || y>9) return false;
		return true;
	}
	static boolean is_stone(int x, int y, int r) {
		if(r == 0) {
			if(x+1 == kx && y == ky) return false;
			if(x+2 == kx && y-1 == ky) return false;
		}else if(r == 1) {
			if(x+1 == kx && y == ky) return false;
			if(x+2 == kx && y+1 == ky) return false;
		}else if(r == 2) {
			if(y+1 == ky && x == kx) return false;
			if(y+2 == ky && x+1 == kx) return false;
		}else if(r == 3) {
			if(y+1 == ky && x == kx) return false;
			if(y+2 == ky && x-1 == kx) return false;
		}else if(r == 4) {
			if(x-1 == kx && y == ky) return false;
			if(x-2 == kx && y+1 == ky) return false;
		}else if(r == 5) {
			if(x-1 == kx && y == ky) return false;
			if(x-2 == kx && y-1 == ky) return false;
		}else if(r == 6) {
			if(y-1 == ky && x == kx) return false;
			if(y-2 == ky && x-1 == kx) return false;
		}else if(r == 7) {
			if(y-1 == ky && x == kx) return false;
			if(y-2 == ky && x+1 == kx) return false;
		}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		return true;
	}
	
	
}
