package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16987 {
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static pair arr[];
	static int N;
	static Queue<pair> q;
	static int ans = 0;
	static boolean bbb[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new pair[N];
		pair[] arr2 = new pair[N];
		for(int i=0;i<N;i++) {
			arr[i] = new pair(sc.nextInt(), sc.nextInt());
			arr2[i] = arr[i];
		}
		bbb = new boolean[N][(1<<N)];
		breakegg(0, arr2, new boolean[N], 0);
		System.out.println(ans);
		
	}
	
	static void breakegg(int now, pair[] cp, boolean[] is_visit, int bb) {
		//System.out.println(now);
		if(now == N) {
			int tmp = 0;
			for(int i=0;i<N;i++) {
				if(cp[i].x <= 0) tmp++;
			}
			ans = Math.max(ans, tmp);
			return;
		}
		if(cp[now].x <= 0) {
			breakegg(now+1, cp, new boolean[N],0);
			return;
		}
		int cnt = 0;
		for(int i=now+1;i<N;i++) {
			if(cp[i].x > 0) cnt++;
		}
		if(0 == cnt) {
			breakegg(N, cp, is_visit,0);
			return;
		}
		for(int i=now+1;i<N;i++) {
			if(is_visit[i]) continue;
			int tmp = bb | (1<<i);
			if(bbb[now][tmp]) continue;
			int nowx = cp[now].x;
			int nowy = cp[now].y;
			int desx = cp[i].x;
			int desy = cp[i].y;
			bbb[now][tmp] = true;
			if(desx <= 0) continue;
			
			cp[i].x-=cp[now].y;
			cp[now].x-=cp[i].y;
			is_visit[i] = true;
			breakegg(now, cp, is_visit, tmp);
			cp[i].x=desx;
			is_visit[i] = false;
			cp[now].x=nowx;
		}
		breakegg(N, cp, is_visit, bb);
		
		
		
	}
	
	
	
}
