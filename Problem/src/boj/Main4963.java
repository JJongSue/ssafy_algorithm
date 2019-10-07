package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4963 {	
	static int N, M;
	static int map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			//System.out.println(N+" "+M);
			map = new int[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int num = 2;
			for(int i=0;i<N;i++) {				
				for(int j=0;j<M;j++) {
					if(map[i][j] == 1) {
						bfs(j, i, num);
						num++;
					}
				}
			}
			sb.append(num-2).append("\n");
		}
		System.out.println(sb);
	}
	static void bfs(int x, int y, int num) {
		for(int i=-1;i<=1;i++) {
			for(int j=-1;j<=1;j++) {
				if(i == 0 && j == 0) continue;
				if(is_map(x+j, y+i)) {
					if(map[y+i][x+j] == 1) {
						map[y+i][x+j] = num;
						bfs(x+j, y+i, num);
					}
				}
			}
		}
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
	
	
	
	
}
