package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16954 {
	static final int dx[] = {0,0,1,0,-1,-1,-1,1,1};
	static final int dy[] = {0,-1,0,1,0,-1,1,1,-1};
	static char map[][] = new char[8][8];
	static boolean is_visit[][] = new boolean[8][8];
	static Queue<dot> wall = new LinkedList<dot>();
	static Queue<dot> man = new LinkedList<dot>();
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<8;i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i=7;i>=0;i--) {
			for(int j=7;j>=0;j--) {
				if(map[i][j] == '#') {
					wall.add(new dot(j, i));
					//System.out.println(i+" "+j);
					is_visit[i][j] = true;
				}
			}
		}
		man.add(new dot(0,7));
		boolean ans = false;
		end:while(!man.isEmpty()) {
			if(wall.size() == 0) {
				ans = true;
				break;
			}
			int size = man.size();
			for(int i=0;i<size;i++) {
				int x = man.peek().x;
				int y = man.poll().y;
				if(!is_visit[y][x]) {
					//System.out.println(x+" "+y);
					for(int s=0;s<9;s++) {
						int xx = x+dx[s];
						int yy = y+dy[s];
						if(is_map(xx, yy) && !is_visit[yy][xx]) {
							if(xx == 7 && yy == 0) {
								ans = true;
								break end;
							}
							man.add(new dot(xx, yy));
						}
					}
				}
				
			}
			size = wall.size();
			for(int i=0;i<size;i++) {
				int x = wall.peek().x;
				int y = wall.poll().y;
				is_visit[y][x] = false;
				if(is_map(x, y+1)) {
					wall.add(new dot(x,y+1));
					is_visit[y+1][x] = true;
				}
			}
			
		}
		if(ans) System.out.println(1);
		else System.out.println(0);
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=8 || y>=8) return false;
		return true;
	}
}
