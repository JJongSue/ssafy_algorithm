package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2422 {
	static int N, M;
	static boolean not[][];
	static int ans = 0;
	static int arr[] = new int[3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		not = new boolean[N+1][N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			not[s][e] = true;
			not[e][s] = true;
		}
		for(int i=1;i<=N;i++) {
			for(int j=i+1;j<=N;j++) {
				if(not[i][j]) continue;
				for(int k=j+1;k<=N;k++) {
					if(not[i][k] || not[j][k]) continue;
					ans++;
				}
			}
		}
		
//		select_num(1, 0);
		System.out.println(ans);
		
	}
	static void select_num(int now, int cnt) {
//		System.out.println(now + " " + cnt);
		if(cnt == 3) {
			ans++;
			return;
		}
		if(now == N+1) return;
		boolean is_add = true;
		for(int i=0;i<cnt;i++) {
			if(not[arr[i]][now]) {
				is_add = false;
				break;
			}
		}
		if(is_add) {
			arr[cnt] = now;
			select_num(now+1, cnt+1);
		}
		select_num(now+1, cnt);
	}
}
