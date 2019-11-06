package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4014 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int map[][] = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			for(int i=0;i<N;i++) {
				boolean is_use[] = new boolean[N];
				int post = map[i][0];
				boolean is_end = true;
				end: for(int j=1;j<N;j++) {
					if(map[i][j] == post-1) {
						int cnt=0;
						for(int c=j;c<j+X&&c<N;c++) {
							if(map[i][c] == post-1 && !is_use[c]) {
								is_use[c]=true;
								cnt++;
							}
							else {
								is_end=false;
								break end;
							}
						}
						if(cnt != X) {
							is_end =false;
							break end;
						}
						post=map[i][j];
						j=j+X-1;
						
					}			
					else if(map[i][j] < post-1 || map[i][j] > post+1) {
						is_end = false;
						break end;
					}else if(map[i][j] == post+1) post=map[i][j];
					
					
				}
				if(!is_end) continue;
				post = map[i][N-1];
				end: for(int j=N-2;j>=0;j--) {
					if(map[i][j] == post-1) {
						int cnt=0;
						for(int c=j;c>j-X&&c>=0;c--) {
							if(map[i][c] == post-1 && !is_use[c]) {
								is_use[c]=true;
								cnt++;
							}
							else {
								is_end=false;
								break end;
							}
						}
						if(cnt != X) {
							is_end =false;
							break end;
						}
						post=map[i][j];
						j=j-X+1;
						
					}
					else if(map[i][j] < post-1 || map[i][j] > post+1) {
						is_end = false;
						break end;
					}else if(map[i][j] == post+1) post=map[i][j];	
				}
				
				
				if(is_end) ans++;
			}
			
			for(int j=0;j<N;j++) {
				boolean is_use[] = new boolean[N];
				int post = map[0][j];
				boolean is_end = true;
				end: for(int i=1;i<N;i++) {
					if(map[i][j] == post-1) {
						int cnt=0;
						for(int c=i;c<i+X&&c<N;c++) {
							if(map[c][j] == post-1 && !is_use[c]) {
								is_use[c]=true;
								cnt++;
							}
							else {
								is_end=false;
								break end;
							}
						}
						if(cnt != X) {
							is_end =false;
							break end;
						}
						post=map[i][j];
						i=i+X-1;
						
					}			
					else if(map[i][j] < post-1 || map[i][j] > post+1) {
						is_end = false;
						break end;
					}else if(map[i][j] == post+1) post=map[i][j];
					
					
				}
				if(!is_end) continue;
				post = map[N-1][j];
				end: for(int i=N-2;i>=0;i--) {
					if(map[i][j] == post-1) {
						int cnt=0;
						for(int c=i;c>i-X&&c>=0;c--) {
							if(map[c][j] == post-1 && !is_use[c]) {
								is_use[c]=true;
								cnt++;
							}
							else {
								is_end=false;
								break end;
							}
						}
						if(cnt != X) {
							is_end =false;
							break end;
						}
						post=map[i][j];
						i=i-X+1;
						
					}
					else if(map[i][j] < post-1 || map[i][j] > post+1) {
						is_end = false;
						break end;
					}else if(map[i][j] == post+1) post=map[i][j];	
				}
				
				
				if(is_end) ans++;
			}
			
			
			
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
