package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main12014 {
	static int T, N, map[], K;
	static StringBuilder sb = new StringBuilder();
	static int ans = 0;
	static int D[] = new int[10_001], cnt[],left, right;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			sb.append("Case #").append(tc).append("\n");
			ans = 0;
			left = 0;
			right=1;
			for(int i=1;i<10_001;i++) D[i] = 10_001;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cnt = new int[N];
			map = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) map[i] = Integer.parseInt(st.nextToken()); 
			
			D[1] = map[0];
			cnt[0] = 1;
			
			lis(1);
			
			
			
			if(ans >= K) sb.append("1").append("\n");
			else sb.append("0").append("\n");
			
		}
		System.out.println(sb);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	static int bs(int num) {
		int l = left;
		int r = right;
		while(l<=r) {
			int mid = (l+r)/2;
			if( num <= D[mid]) {
				r = mid-1;
			}else {
				l = mid+1;
			}
		}
		//System.out.println(l + " " + r);
		
		return l;
	}
	
	static void lis(int now) {
		for(int i=1;i<N;i++) {
			int tmp = bs(map[i]);
			if(tmp+1 > right) right = tmp+1;
			D[tmp+1] = map[i];
			System.out.println(tmp);
			//System.out.println(Arrays.toString(D));
			cnt[i] = tmp+1;
			ans = Math.max(ans, tmp+1);
			if(ans == K) return;
			
		}
	}
	
	
	
	
	
	
	
	
	
}
