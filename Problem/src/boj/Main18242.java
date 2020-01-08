package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18242 {
	static char map[][];
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		boolean is_start = false;
		int sx=0, sy=0, ex=0, ey=0;
		String ans = "";
		end:for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				//System.out.println(i+" "+j);
				//System.out.println(map[i][j]);
				if(map[i][j] == '#') {
					sx = j;
					sy = i;
					for(int x=j;x<M;x++) {
						if(map[i][x] == '.' && x==M-1) {
							ex=x-1;
							break end;
						}
						if(map[i][x] == '.' ) {
							if(map[i][x+1] == '.') {
								ex = x-1;
								break end;
							}
							else {
								ans = "UP";
							}
						}
					}
					ex = M-1;
					break end;
				}
			}
		}
		ey = sy + (ex - sx);
		if(ans.equals("")) {
			for(int i=sy+1;i<=ey;i++) {
				if(map[i][sx] == '.') {
					ans = "LEFT";
					break;
				}
				if(map[i][ex] == '.') {
					ans = "RIGHT";
					break;
				}
			}
			
		}
		if(ans.equals("")) {
			for(int i=sx;i<=ex;i++) {
				if(map[ey][i] == '.') {
					ans = "DOWN";
					break;
				}
			}
			
		}
		//System.out.println(sx + " " + sy + " " + ex + " " + ey);
		System.out.println(ans);
		
	}
}
