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
		breakegg(0, arr2);
		System.out.println(ans);
		
	}
	
	static void breakegg(int now, pair[] cp) {
		//System.out.println(now);
		if(now >= N) {
			int cnt = 0;
			for(int i=0;i<N;i++) {
				if(cp[i].x<=0) cnt++;
			}
			/*if(ans < cnt) {
				for(int i=0;i<N;i++) {
					if(cp[i].x<=0) System.out.print(i+" ");
				}
				System.out.println();
				System.out.println(cnt);
			}*/
			ans = Math.max(ans, cnt);
			return;
		}
		if(cp[now].x<= 0) {
			breakegg(now+1, cp);			
			return;
		}		
		
		boolean  is_go = true;
		for(int i=0;i<N;i++) {
			if(i==now) continue;			
			//System.out.println(now+" i : "+i);
			if(cp[i].x <=0) {				
				continue;
			}
			is_go = false;
			int nowx = cp[now].x;
			int iix = cp[i].x;
			cp[now].x -= cp[i].y;
			cp[i].x -= cp[now].y;
			
			breakegg(now+1, cp);
			cp[now].x = nowx;
			cp[i].x = iix;
			
		}
		if(is_go) breakegg(now+1, cp);
		
		
	}
	
	
	
}
