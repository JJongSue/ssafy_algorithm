package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution6109 {
	static int map[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String comand = st.nextToken();
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(comand.equals("up")) up();
			else if(comand.equals("down")) down();
			else if(comand.equals("left")) left();
			else if(comand.equals("right")) right();
			
			
			sb.append("#").append(tc).append("\n");
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}
	
	
	static void up() {
		for(int j=0;j<N;j++) {
			for(int i=0;i<N;i++) {
				int now = map[i][j];
				if(now == 0) {
					for(int k=i+1;k<N;k++) {
						if(map[k][j] != 0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							i--;
							break;
						}
					}
				}else {
					for(int k=i+1;k<N;k++) {
						if(map[k][j] == 0) continue;
						if(now == map[k][j]) {
							map[i][j] *= 2;
							map[k][j] =0;
							break;
						}else {
							break;
						}
					}
				}				
				
			}
		}
	}
	static void down() {
		for(int j=0;j<N;j++) {
			for(int i=N-1;i>=0;i--) {
				int now = map[i][j];
				if(now == 0) {
					for(int k=i-1;k>=0;k--) {
						if(map[k][j] != 0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							i++;
							break;
						}
					}
				}else {
					for(int k=i-1;k>=0;k--) {
						if(map[k][j] == 0) continue;
						if(now == map[k][j]) {
							map[i][j] *= 2;
							map[k][j] =0;
							break;
						}else {
							break;
						}
					}
				}				
				
			}
		}
		
		
		
	}
	static void left() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int now = map[i][j];
				if(now == 0) {
					for(int k=j+1;k<N;k++) {
						if(map[i][k] != 0) {
							map[i][j] = map[i][k];
							map[i][k] = 0;
							j--;
							break;
						}
					}
				}else {
					for(int k=j+1;k<N;k++) {
						if(map[i][k] == 0) continue;
						if(now == map[i][k]) {
							map[i][j] *= 2;
							map[i][k] =0;
							break;
						}else {
							break;
						}
					}
				}				
				
			}
		}
		
		
	}
	static void right() {
		for(int i=0;i<N;i++) {
			for(int j=N-1;j>=0;j--) {
				int now = map[i][j];
				if(now == 0) {
					for(int k=j-1;k>=0;k--) {
						if(map[i][k] != 0) {
							map[i][j] = map[i][k];
							map[i][k] = 0;
							j++;
							break;
						}
					}
				}else {
					for(int k=j-1;k>=0;k--) {
						if(map[i][k] == 0) continue;
						if(now == map[i][k]) {
							map[i][j] *= 2;
							map[i][k] =0;
							break;
						}else {
							break;
						}
					}
				}				
				
			}
		}
	}
}
