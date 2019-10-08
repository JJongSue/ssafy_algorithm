package boj;

import java.util.Scanner;

public class Main10971 {
	static int N, ans;
	static int map[][];
	static boolean []is_visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ans = Integer.MAX_VALUE;
		
		is_visit = new boolean[N+1];
		for(int i=1;i<N;i++) {
			if(map[0][i] == 0) continue;
			is_visit[i] = true;
			select(i, 1, map[0][i]);
			is_visit[i] = false;
		}
		System.out.println(ans);
		
	}
	static void select(int x, int cnt, int answer) {
		if(answer > ans) return;
		if(cnt == N-1) {
			if(map[x][0] == 0) return;
 			if(answer+map[x][0] < ans) ans = answer+map[x][0];
			return;
		}
		
		for(int i=1;i<N;i++) {
			if(x == i) continue;
			if(!is_visit[i] && map[x][i] != 0) {
				is_visit[i] = true;				
				select(i, cnt+1, answer+map[x][i]);
				is_visit[i] = false;
			}
		}
	}
}
