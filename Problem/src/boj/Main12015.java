package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12015 {
	static int N;
	static int map[], D[], cnt[];
	static int ans = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		D = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			map[i] = Integer.parseInt(st.nextToken());
			D[i] = 1_000_001;
		}
		D[N] = 1_000_001;
		D[0] = 0;
		D[1] = map[0];
		int right = 1;
		for(int i=1;i<N;i++) {
			int tmp = bs(0, right, map[i]);
			if(right < tmp) right = tmp;
			D[tmp] = map[i];
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
		
		
		
	}
	
	static int bs(int left, int right, int now) {
		int l = left;
		int r = right;
		while(l<=r) {
			int mid = (l+r)/2;
			if(now <= D[mid]) {
				r = mid-1;
			}else {
				l = mid+1;
			}
		}
		return l;
	}

}
