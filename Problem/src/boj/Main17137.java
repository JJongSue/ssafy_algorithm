package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17137 {
	static final long div = 1_000_000_007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
//			long dp = 1;
			int min = 200;
			int map[] = new int[N];
			for(int i=0;i<N;i++) {
				map[i] = Integer.parseInt(st.nextToken());
//				int tmp = Integer.parseInt(st.nextToken());
//				dp = (dp * tmp) % div;
//				min = Math.min(tmp, min);
			}
			Arrays.sort(map);
//			System.out.println(Arrays.toString(map));
			int max = map[N-1];
			long dp[][] = new long[max+1][N];
			int cnt[][] = new int[max+1][N];
			for(int i=1;i<=map[0];i++) {
				cnt[i][0] = 1;
				dp[i][0] = i;
			}
			for(int i=1;i<N;i++) {
				for(int j=1;j<=map[i];j++) {
					if(j < map[i-1]) {
						cnt[j][i] = (int) dp[j][i-1];
					}else {
						cnt[j][i] = (int) (dp[map[i-1]][i-1]);
					}
					dp[j][i] = (dp[j-1][i] + cnt[j][i] ) % div;
				}
			}
			long sum = 0;
			for(int i=0;i<=map[N-1];i++) {
//				System.out.println(cnt[i][N-1]);
				sum = (sum + cnt[i][N-1]) % div;
			}
			sum = (sum * N) % div;
			System.out.println(sum);
//			dp -= min;
//			dp = (dp * N) % div;
//			if(N == 1) {
//				System.out.println(min);
//			}else {
//				System.out.println(min);
//				System.out.println(dp);				
//			}
		}
	}
}
