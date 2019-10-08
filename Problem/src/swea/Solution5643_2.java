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
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5643_2 {
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
			
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
				arr[b][a] = -1;
			}
			Queue<Integer> q, q2;
			int []cnt = new int[N+1];
			for(int i=1;i<=N;i++) {				
				is_visit = new boolean[N+1];
				is_visit[i] = true;
				q = new LinkedList<Integer>();
				q2 = new LinkedList<Integer>();
				for(int j=1;j<=N;j++) {
					if(arr[i][j] == 1) {
						q.add(j);
						is_visit[j] = true;
						cnt[i]++;
					}
					if(arr[i][j] == -1) {
						q2.add(j);
						is_visit[j] = true;
						cnt[i]++;
					}				
				}
				while(!q.isEmpty()) {
					int tmp = q.poll();
					for(int j=1;j<=N;j++) {
						if(!is_visit[j] && arr[tmp][j] == 1) {
							q.add(j);
							cnt[i]++;
							is_visit[j]=true;
						}
					}
				}
				while(!q2.isEmpty()) {
					int tmp = q2.poll();
					for(int j=1;j<=N;j++) {
						if(!is_visit[j] && arr[tmp][j] == -1) {
							q2.add(j);
							cnt[i]++;
							is_visit[j]=true;
						}
					}
				}
			}
			
			int answer =0;
			for(int i=1;i<=N;i++) {				
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
