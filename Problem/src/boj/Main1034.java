package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1034 {
	static boolean [][]map;
	static int N, M;
	static int ans = 0;
	static int max_range;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int [] arr = new int[N];
		map = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++) {
				if(tmp.charAt(j) == '1') map[i][j]=true;;
			}
		}
		int K = Integer.parseInt(br.readLine());
		if(K == 0) {
			int number = 0;
			for(int i=0;i<N;i++) {
				boolean is_ok=true;
				for(int j=0;j<M;j++) {
					if(!map[i][j]) {
						is_ok=false;
						break;
					}
				}
				if(is_ok) number++;
			}
			
			System.out.println(number);
		}else if(K%2 == 0) {
			max_range = K/2;
			if(K > M) {
				max_range = M/2;
			}
			for(int i=0;i<N;i++) {
				boolean is_ok=true;
				for(int j=0;j<M;j++) {
					if(!map[i][j]) {
						is_ok=false;
						break;
					}
				}
				if(is_ok) ans++;
								
			}
			find_num(0, 0, 1);
			System.out.println(ans);
		}else {
			max_range = K/2+K%2;
			if(K > M) {
				max_range = M/2+M%2;
			}
			
			find_num2(0, 0, 1);
			System.out.println(ans);
		}
		
		
	}
	static void find_num(int now, int cnt, int howmany) {
		if(now == M) return;
		if(cnt == howmany) {
			int number = 0;
			for(int i=0;i<N;i++) {
				boolean is_ok=true;
				for(int j=0;j<M;j++) {
					if(!map[i][j]) {
						is_ok=false;
						break;
					}
				}
				if(is_ok) number++;
			}
			if(ans < number) ans = number;
			return;
		}
		if(now == 0) {
			for(int i=1;i<=max_range;i++) {
				if(howmany > i*2) continue;
				find_num(now+1, cnt, i*2);
			}
			for(int i=0;i<N;i++) {
				if(map[i][now]) map[i][now]=false;
				else map[i][now]=true;
			}
			for(int i=1;i<=max_range;i++) {
				if(howmany > i*2) continue;
				find_num(now+1, cnt+1, i*2);
			}
			for(int i=0;i<N;i++) {
				if(map[i][now]) map[i][now]=false;
				else map[i][now]=true;
			}
		}else {
			find_num(now+1, cnt, howmany);
			for(int i=0;i<N;i++) {
				if(map[i][now]) map[i][now]=false;
				else map[i][now]=true;
			}
			find_num(now+1, cnt+1, howmany);
			for(int i=0;i<N;i++) {
				if(map[i][now]) map[i][now]=false;
				else map[i][now]=true;
			}
		}
		return;
		
		
	}
	static void find_num2(int now, int cnt, int howmany) {		
		if(cnt == howmany) {
			int number = 0;
			for(int i=0;i<N;i++) {
				boolean is_ok=true;
				for(int j=0;j<M;j++) {
					if(!map[i][j]) {
						is_ok=false;
						break;
					}
				}
				if(is_ok) number++;
			}
			if(ans < number) ans = number;
			return;
		}
		if(now == M) return;
		if(now == 0) {
			for(int i=1;i<=max_range;i++) {
				if(howmany > (i*2)-1) continue;
				find_num2(now+1, cnt, (i*2)-1);
			}
			for(int i=0;i<N;i++) {
				if(map[i][now]) map[i][now]=false;
				else map[i][now]=true;
			}
			for(int i=1;i<=max_range;i++) {
				if(howmany > (i*2)-1) continue;
				find_num2(now+1, cnt+1, (i*2)-1);
			}
			for(int i=0;i<N;i++) {
				if(map[i][now]) map[i][now]=false;
				else map[i][now]=true;
			}
		}else {
			find_num2(now+1, cnt, howmany);
			for(int i=0;i<N;i++) {
				if(map[i][now]) map[i][now]=false;
				else map[i][now]=true;
			}
			find_num2(now+1, cnt+1, howmany);
			for(int i=0;i<N;i++) {
				if(map[i][now]) map[i][now]=false;
				else map[i][now]=true;
			}
		}
		
		return;
		
		
	}
	
	
}
