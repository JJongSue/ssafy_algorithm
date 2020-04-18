package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10942 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		boolean dp[][] = new boolean[N][N];
		
		int M = Integer.parseInt(br.readLine()); 
		subPalin(arr, dp, N);
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			sb.append(dp[s][e] ? "1\n" : "0\n");
		}
		System.out.println(sb);
	}
	
	private static void subPalin(int arr[], boolean dp[][], int n) {
		int i, j;
		for(i=0;i<n;i++) {
			for(j=i;j<n;j++) {
				dp[j][i] = dp[i][j] = is_pal(arr, i, j);
			}
		}
	}
	static boolean is_pal(int arr[], int s, int e) {
		if(s<e) {
			int n = s+(e-s) / 2 + (e-s)%2;
			while(s<=n) {
				if(arr[s++] != arr[e--] ) return false;
			}
		}
		return true;
	}
}
