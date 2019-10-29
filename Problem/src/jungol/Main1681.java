package jungol;

import java.util.Scanner;

public class Main1681 {
	static int N;
	static int map[][];
	static boolean is_visit[];
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		is_visit = new boolean[N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		go(0,0,0);
		System.out.println(ans);
		
		
	}
	static void go(int cnt, int cost, int now) {
		if(cnt == N-1) {
			if(map[now][0] != 0) {
				ans = Math.min(ans, map[now][0]+cost);
			}
			return;
		}
		if(cost > ans) return;
		for(int i=1;i<N;i++) {
			if(!is_visit[i] && map[now][i] != 0) {
				is_visit[i] = true;				
				go(cnt+1, (cost+map[now][i]), i);
				is_visit[i] = false;
			}
		}
	}
	
}
