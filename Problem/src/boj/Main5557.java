package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5557 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i=0;i<N-1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(st.nextToken());
		long dp[][] = new long[21][N];
		dp[arr[0]][0] = 1;
		for(int i=1;i<N;i++) {
			for(int j=0;j<21;j++) {
				if(dp[j][i-1] != 0) {
					if(j-arr[i] >= 0) dp[j-arr[i]][i] += dp[j][i-1];
					if(j+arr[i] <= 20) dp[j+arr[i]][i] += dp[j][i-1];					
				}
				
			}
		}
		long ans = 0;
		/*for(int i=0;i<21;i++) {
			ans += dp[i][N-1];
			System.out.print(dp[i][N]+" ");
		}*/
		System.out.println(dp[M][N-2]);
	}
}
