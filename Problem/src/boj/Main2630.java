package boj;

import java.util.Scanner;

public class Main2630 {
	static int[][] map;
	static int blue, white;
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		blue = 0;
		white=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
				/*if(map[i][j]==0) white++;
				else blue++;*/
			}
		}
		/*blue=0;
		white=0;*/
		cnt_color(0,0, N );
		System.out.println(white);
		System.out.println(blue);
		
		
	}
	
	
	static void cnt_color(int x, int y, int size) {
		if(size == 1) {
			if(map[y][x] == 0) white++;
			else if(map[y][x] == 1) blue++;
			return;
		}
		int now_color = map[y][x];
		if(now_color == -1) {
			cnt_color(x,y, size/2);
			cnt_color(x+size/2,y+size/2, size/2);
			cnt_color(x+size/2,y, size/2);
			cnt_color(x,y+size/2, size/2);
			return;
		}
		for(int i=y;i<y+size;i++) {
			for(int j=x;j<x+size;j++) {
				if(map[i][j] != now_color) {
					cnt_color(x,y, size/2);
					cnt_color(x+size/2,y+size/2, size/2);
					cnt_color(x+size/2,y, size/2);
					cnt_color(x,y+size/2, size/2);
					return;
				}
			}
		}
		if(map[y][x] == 0) white++;
		else blue++;
		for(int i=y;i<y+size;i++) {
			for(int j=x;j<x+size;j++) {
				map[i][j] = -1;
			}
		}
		
		
		
	}
	
}
