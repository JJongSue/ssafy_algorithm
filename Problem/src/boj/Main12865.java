package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main12865 {
	static int vmap[];
	static int wmap[];
	static int N, K;
	static int dp[][];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		wmap = new int[N];
		vmap = new int[N];
		dp = new int[N][K+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			wmap[i] = w;
			vmap[i] = v;
		}
		int ans = 0;
		for(int i=wmap[0];i<=K;i++) dp[0][i] = vmap[0];
		for(int i=1;i<N;i++) {
			for(int j=0;j<=K;j++) {
				dp[i][j] = dp[i-1][j];
				if(j>=wmap[i]) dp[i][j] = Math.max(dp[i][j], vmap[i]);
				if(j-wmap[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-wmap[i]]+vmap[i]);	
				}
				ans = Math.max(dp[i][j], ans);
			}
		}
		System.out.println(ans);
	}
}
