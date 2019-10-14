package boj;

import java.util.Scanner;

public class Main14889 {
	static int N;
	static int[][] map;
	static boolean select[];
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		select = new boolean[N];
		select_team(0,0);
		System.out.println(ans);
		
		
		
	}
	static void select_team(int now, int cnt) {
		if(cnt == N/2) {
			int t=0, f=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(select[i] && select[j]) t+=map[i][j];
					else if (!select[i] && !select[j]) f+=map[i][j];
				}
			}
			int tmp = Math.abs(t-f);
			if(ans > tmp) ans = tmp;			
			return;
		}
		if(now == N) return;
		select_team(now+1, cnt);
		select[now] = true;
		select_team(now+1, cnt+1);
		select[now] = false;
		
	}
}
