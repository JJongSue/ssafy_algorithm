package swea;

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

*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution5643 {
	static boolean[] is_visit;
	static int[][] arr;
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			arr = new int[N+1][N+1];
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				is_visit = new boolean[N+1];
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				is_visit[a] = true;
				is_visit[b] = true;
				arr[b][a] = 1;
				arr[a][b] = -1;
				for(int j=1;j<=N;j++) {
					if(!is_visit[i] && arr[i][b] == 1 && arr[i][a] == 0) {
						is_visit[i]=true;
						arr[i][a] = 1;
						arr[a][i] = -1;
						go(i, a, b);
						
					}
					
				}
			}
		}
		for(int i=0;i<N;i++) System.out.println(Arrays.toString(arr[i]));
	}
	
	static void go(int now, int a, int b) {
		for(int i=1;i<=N;i++) {
			if(!is_visit[i] && arr[i][now] == 1 ) {
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
			if(!is_visit[i] && arr[i][now] == 1 ) {
				is_visit[i] = true;
				if(arr[i][a] != 0 && arr[i][b] != 0) continue;
				arr[i][a] = 1;
				arr[i][b] = 1;
				arr[a][i] = -1;
				arr[b][i] = -1;
				go(i, a, b);
			}
			is_visit[i] = true;
		}
	}
	
	
}
