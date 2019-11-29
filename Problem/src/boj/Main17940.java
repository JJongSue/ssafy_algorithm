package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17940 {
	static int dis[][], max_dist[][][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int company[] = new int[N];
		for(int i=0;i<N;i++) {
			company[i] = Integer.parseInt(br.readLine());
		}
		dis = new int[N][N];
		max_dist = new int[N][N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				dis[i][j] = Integer.parseInt(st.nextToken());
				if(dis[i][j] != 0) {
					max_dist[i][j][1] = dis[i][j];
					if(company[i] != company[j]) max_dist[i][j][0]=1;
				}else {
					max_dist[i][j][0] = 987654;
					max_dist[i][j][1] = 987654321;
				}
			}
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				//if(dis[i][k] == 0) continue;
				for(int j=0;j<N;j++) {
					//if(dis[j][k] == 0) continue;
					int cnt = 0;
					if(company[i] != company[k]) cnt++;
					if(company[j] != company[k]) cnt++;
					if(max_dist[i][j][1]>=987654321) {
						max_dist[i][j][0] = max_dist[i][k][0]+max_dist[k][j][0]+cnt;
						max_dist[i][j][1] = max_dist[i][k][1]+max_dist[k][j][1];
					}
					else if(max_dist[i][j][0] > max_dist[i][k][0]+max_dist[k][j][0]+cnt) {
						max_dist[i][j][0] = max_dist[i][k][0]+max_dist[k][j][0]+cnt;
						max_dist[i][j][1] = max_dist[i][k][1]+max_dist[k][j][1];
					}else if(max_dist[i][j][0] == max_dist[i][k][0]+max_dist[k][j][0]+cnt) {
						if(max_dist[i][j][1] > max_dist[i][k][1]+max_dist[k][j][1])
						max_dist[i][j][1] = max_dist[i][k][1]+max_dist[k][j][1];
					}
					
					
				}
			}
		}
		System.out.println(max_dist[0][M][0]+" "+max_dist[0][M][1]);
		
		
		
	}
}
