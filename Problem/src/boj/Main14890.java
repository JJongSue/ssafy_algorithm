package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14890 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int [][]map = new int[N][N];
		boolean is_use[][] = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans=0;
		for(int i=0;i<N;i++) {
			int last = map[i][0];
			boolean is_go = true;
			end: for(int j=1;j<N;j++) {
				if(map [i][j] < last) last = map[i][j];
				else if(map[i][j] - last == 1) {
					if(j-L < 0) {
						is_go = false;
						break;
					}
					for(int k=j-L;k<j;k++) {
						if(map[i][k] != last || is_use[i][k]) {
							is_go =false;
							break end;
						}
					}
					for(int k=j-L;k<j;k++) {						
						is_use[i][k] =true;					
					}
					last = map[i][j];					
				}else if(map[i][j]-last > 1) {
					is_go = false;
					break;
				}
			}
			if(is_go) {
				last = map[i][N-1];
				end: for(int j=N-2;j>=0;j--) {
					if(map [i][j] < last) last = map[i][j];
					else if(map[i][j] - last == 1) {
						if(j+L >= N) {
							is_go = false;
							break;
						}
						for(int k=j+L;k>j;k--) {
							if(map[i][k] != last || is_use[i][k]) {
								is_go =false;
								break end;
							}
						}
						for(int k=j+L;k>j;k--) {						
							is_use[i][k] =true;					
						}
						last = map[i][j];					
					}else if(map[i][j]-last > 1) {
						is_go = false;
						break;
					}
				}
				
			}
			if(is_go) {
				//System.out.println("y"+i);
				ans++;			
			}
		}
		
		
		for(int i=0;i<N;i++) {
			int last = map[0][i];
			boolean is_go = true;
			is_use = new boolean[N][N];
			end: for(int j=1;j<N;j++) {
				if(map [j][i] < last) last = map[j][i];
				else if(map[j][i] - last == 1) {
					if(j-L < 0) {
						is_go = false;
						break;
					}
					for(int k=j-L;k<j;k++) {
						if(map[k][i] != last || is_use[k][i]) {
							is_go =false;
							break end;
						}
					}
					for(int k=j-L;k<j;k++) {						
						is_use[k][i] =true;						
					}
					last = map[j][i];					
				}else if(map[j][i]-last > 1) {
					is_go = false;
					break;
				}
			}
			if(is_go) {
				last = map[N-1][i];
				end: for(int j=N-2;j>=0;j--) {
					if(map [j][i] < last) last = map[j][i];
					else if(map[j][i] - last == 1) {
						if(j+L >= N) {
							//System.out.println(1);
							is_go = false;
							break;
						}
						for(int k=j+L;k>j;k--) {
							if(map[k][i] != last || is_use[k][i]) {
								//System.out.println(2);
								is_go =false;
								break end;
							}
						}
						for(int k=j+L;k>j;k--) {						
							is_use[k][i] =true;					
						}
						last = map[j][i];					
					}else if(map[j][i]-last > 1) {
						is_go = false;
						break;
					}
				}
				
			}
			if(is_go) {
				ans++;
				//System.out.println(i+"x ");
			}
		}
		
		
		
		
			
			
			
		
		System.out.println(ans);
		
	}
}
