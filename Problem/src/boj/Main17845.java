package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main17845 {
	static int N, K;
	static pair arr[];
	static long dp[];
	static long ans = 0;
	static class pair{
		int i;
		int t;
		public pair(int i, int t) {
			super();
			this.i = i;
			this.t = t;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new pair[K];
		dp = new long[N+1];
		for(int i=1;i<=N;i++) dp[i] = -1;
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			arr[i] = new pair(I, t);
		}
		Arrays.sort(arr, new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				if(o1.t == o2.t) {
					return o2.i - o1.i;
				}
				return o1.t - o2.t;
			}
		});
		get_max(0);
		System.out.println(ans);
		
	}
	
	static void get_max(int now) {
		if(now == K) return;
		int I = arr[now].i;
		int T = arr[now].t;
		for(int i=N;i>=T;i--) {
			dp[i] = Math.max(dp[i], dp[i-T] + I);
			ans = Math.max(dp[i], ans);
		}
		get_max(now+1);
		
	}
}
