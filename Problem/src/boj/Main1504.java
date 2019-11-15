package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1504 {
	static int N, E;
	static int dismap[][];
	/*static boolean is_visit[];
	static ArrayList<pair> al[];
	static class pair{
		int to;
		int dis;
		public pair(int to, int dis) {
			super();
			this.to = to;
			this.dis = dis;
		}	
	}	*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dismap = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i == j) continue;
				dismap[i][j] = 1001;
			}
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			dismap[a][b]=c;
			dismap[b][a]=c;
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					dismap[i][j] = Math.min(dismap[i][j], dismap[i][k]+dismap[k][j]);
				}
			}
		}
		
		int first = -1;
		int second = -1;
		if(dismap[0][a] >= 1001 || dismap[a][b] >= 1001 || dismap[b][N-1] >= 1001) first=-1;
		else first = dismap[0][a]+dismap[a][b]+dismap[b][N-1];
		
		if(dismap[0][b] >= 1001 || dismap[a][b] >= 1001 || dismap[a][N-1] >= 1001) second=-1;
		else second = dismap[0][b]+dismap[a][b]+dismap[a][N-1];
		
		if(first == -1 && second == -1) System.out.println(-1);
		else {
			if(first == -1) System.out.println(second);
			else if(second == -1) System.out.println(first);
			else System.out.println(Math.min(first, second));
		}
		

		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
