package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5644 {
	//0 움직임x 1234북동남서
	static final int dx[] = {0,0,1,0,-1};
	static final int dy[] = {0,-1,0,1,0};
	// 
	static int pmap[][][] = new int[10][10][20];
	
	
	//x, y의 이동 경로를 저장할 
	static int mx[];
	static int my[];
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			mx = new int[N];
			my = new int[N];
			pmap = new int[10][10][M];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				mx[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				my[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int s=0;s<M;s++) {
				st = new StringTokenizer(br.readLine());
				int tmpx = Integer.parseInt(st.nextToken())-1;
				int tmpy = Integer.parseInt(st.nextToken())-1;
				int tmpd = Integer.parseInt(st.nextToken());
				int tmpp = Integer.parseInt(st.nextToken());
				for(int i=-tmpd;i<=tmpd;i++) {
					for(int j=-tmpd;j<=tmpd;j++) {
						if(Math.abs(i)+Math.abs(j)<=tmpd && is_map(tmpx+j, tmpy+i)) {
							pmap[tmpy+i][tmpx+j][s] = tmpp;
						}
					}
				}
			}
			int fx=0, fy=0, sx=9,sy=9;
			int sum = 0;
			int ttt = 0;
			for(int num=0;num<M;num++) {
				if(pmap[fy][fx][num] > ttt) {
					ttt = pmap[fy][fx][num];
				}
			}
			
			sum += ttt;
			ttt = 0;
			for(int num=0;num<M;num++) {
				if(pmap[sy][sx][num] > ttt) {
					ttt = pmap[sy][sx][num];
				}
			}
			sum += ttt;
			for(int time=0;time<N;time++) {				
				fx += dx[mx[time]];
				fy += dy[mx[time]];
				int iter = -1;
				int max = 0;
				for(int num=0;num<M;num++) {
					if(pmap[fy][fx][num] > max) {
						max = pmap[fy][fx][num];
						iter = num;
					}
				}
				int tmpsum = 0;
				tmpsum += max;
				
				
				//sum += pmap[fy][fx][0];
				//System.out.print(max+" ");
				sx += dx[my[time]];
				sy += dy[my[time]];
				max = 0;
				for(int num=0;num<M;num++) {
					if(num == iter) continue;
					if(pmap[sy][sx][num] > max) {
						max = pmap[sy][sx][num];
						//iter = num;
					}
				}
				tmpsum+= max;
				iter = -1;
				max = 0;
				for(int num=0;num<M;num++) {
					if(pmap[sy][sx][num] > max) {
						max = pmap[sy][sx][num];
						iter = num;
					}
				}
				int tmpsum2 = max;
				max = 0;
				for(int num=0;num<M;num++) {
					if(num == iter) continue;
					if(pmap[fy][fx][num] > max) {
						max = pmap[fy][fx][num];
						//iter = num;
					}
				}
				tmpsum2+=max;
				sum += Math.max(tmpsum, tmpsum2);

			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");

		}
		
		System.out.println(sb);
		
		
	}
	
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=10 || y>=10) return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
