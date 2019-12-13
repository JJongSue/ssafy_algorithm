package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4062 {
	static int dpx[][] = new int[1001][1001];
	static int dpy[][] = new int[1001][1001];
	static int map[][] = new int[1000][1000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				String tmp = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = tmp.charAt(j)-'0';
					dpx[i][j] = 0;
					dpy[i][j] = 0;
				}
			}
			int max = 0;
			for(int i=N-1;i>=0;i--) {
				for(int j=N-1;j>=0;j--) {
					if(map[i][j] == 0) {
						dpx[i][j]++;
						dpy[i][j]++;
						if(i+1<N) dpy[i][j] += dpy[i+1][j];
						if(j+1<N) dpx[i][j] += dpx[i][j+1];
						int min = min(dpx[i][j], dpy[i][j]);
						int minx = min;
						for(int k=i+1;k<N&&k<i+min;k++) {
							if(dpx[k][j] == 0 ) {
								minx = min(minx, k-i);
							}else {
								if(k-i+1>dpx[k][j]) minx = min(minx, k-i);
								else minx = min(minx, dpx[k][j]);
							}
						}
						
						
						/*if(i+1<N && j+1<N) {
							dpx[i][j] = min(dpx[i][j+1]+1, dpx[i+1][j]);
							dpy[i][j] = min(dpy[i][j+1], dpy[i+1][j]+1);
						}else if(i+1<N) {
							dpy[i][j] = dpy[i+1][j]+1;
						}else if(j+1<N) {
							dpx[i][j] = dpx[i][j+1]+1;
						}
						if(dpx[i][j] < 1) dpx[i][j]=1;
						if(dpy[i][j] < 1) dpy[i][j]=1;*/
						
						//int min = dpx[i][j];
						//if(min > dpy[i][j]) min = dpy[i][j];
						if(max < minx) max = minx;
					}
					
				}
			}
			/*for(int i=0;i<N;i++) {				
				for(int j=0;j<N;j++) {
					//System.out.print(Math.min(dpx[i][j],dpy[i][j] ));
					System.out.print(dpy[i][j]);
				}System.out.println();
			}
			for(int i=0;i<N;i++) {				
				for(int j=0;j<N;j++) {
					//System.out.print(Math.min(dpx[i][j],dpy[i][j] ));
					System.out.print(dpx[i][j]);
				}System.out.println();
			}*/
			System.out.println("#"+tc+" "+max);
		}
	}
	static int min(int x, int y) {
		if(x>y) return y;
		else return x;
	}
	
}
