package swea;

import java.io.BufferedReader;

/*
1
6
6
1 5
3 4
5 4
4 2
4 6
5 2
// https://github.com/Karmantez/SWExpertAcademy/blob/master/5643%ED%82%A4%EC%88%9C%EC%84%9C/src/Solution.java
*/

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution5643 {
	static boolean[] is_visit;
	static final int inf = 987654321;
	static int[][] arr;
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1; tc<=T;tc++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());			
			
			arr = new int[N+1][N+1];
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(i == j) arr[i][j] = 0;
					arr[i][j] = inf;
				}
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(i == j) continue;
					for(int k=1;k<=N;k++) {
						arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
					}
				}
			}
			int []cnt = new int[N+1];
			int answer =0;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(arr[i][j] < inf || arr[j][i] < inf) {
						cnt[i]++;
					}
				}
				if(cnt[i] == N-1) answer++;
			}
			//System.out.println(Arrays.toString(cnt));
			System.out.println("#"+tc+" "+answer);				
		}
		
	}
	
	static void go(int now, int a, int b) {
		for(int i=1;i<=N;i++) {
			if(!is_visit[i] && arr[now][i] == 1 ) {
				is_visit[i] = true;
				if(arr[i][a] != 0 && arr[i][b] != 0) continue;
				arr[i][a] = 1;
				arr[i][b] = 1;
				arr[a][i] = -1;
				arr[b][i] = -1;
				go(i, a, b);
			}
		}
	}
	static void go2(int now, int a, int b) {
		for(int i=1;i<=N;i++) {
			if(!is_visit[i] && arr[now][i] == -1 ) {
				is_visit[i] = true;
				if(arr[i][a] != 0 && arr[i][b] != 0) continue;
				arr[i][a] = -1;
				arr[i][b] = -1;
				arr[a][i] = 1;
				arr[b][i] = 1;
				go(i, a, b);
			}
			
		}
	}
	
	
}
