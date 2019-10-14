package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15686 {
	static ArrayList<pair> home, chick, sc;
	static int N, M;
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new ArrayList<>();
		chick = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) home.add(new pair(j, i));
				else if(tmp == 2) chick.add(new pair(j, i));
			}
		}
		if(M == chick.size()) {
			for(pair p : home) {
				int min = Integer.MAX_VALUE;
				for(pair p2 : chick) {
					int tmp = Math.abs(p2.x-p.x)+Math.abs(p2.y-p.y);
					min = Math.min(min, tmp);
				}
				ans+=min;
			}
		}else {
			ans = Integer.MAX_VALUE;
			sc = new ArrayList<>();			
			select_c(0, 0);
		}
		
		System.out.println(ans);
		
	}
	static void select_c(int now, int cnt) {
		if(cnt == M) {
			int tmpans = 0;
			for(pair p : home) {
				int min = Integer.MAX_VALUE;
				for(pair p2 : sc) {
					int tmp = Math.abs(p2.x-p.x)+Math.abs(p2.y-p.y);
					min = Math.min(min, tmp);
				}
				tmpans+=min;
			}
			ans = Math.min(ans, tmpans);
			return;
		}
		
		if(now == chick.size()) return;
		select_c(now+1, cnt);
		sc.add(chick.get(now));
		select_c(now+1, cnt+1);
		sc.remove(sc.size()-1);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
