package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2003 {
	static int N, M, map[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) map[i] = Integer.parseInt(st.nextToken());
		
		int l = 0, r=0;
		int sum = map[0];
		int ans = 0;
		//if(sum == M) ans++;
		while(true) {
			if(sum == M) {
				ans++;
				r++;
				if(N==r) break;
				sum+=map[r];
			}else if(sum < M) {
				r++;
				if(N==r) break;
				sum+=map[r];
			}else if(M < sum) {
				sum-=map[l];
				l++;
				if(N==l) break;
			}
		}
		System.out.println(ans);
		
	}
}
