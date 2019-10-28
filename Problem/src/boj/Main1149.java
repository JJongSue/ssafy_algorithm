package boj;

import java.util.Scanner;

public class Main1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[N][3];
		int dp[][] = new int[N][3];
		arr[0][0] = sc.nextInt();
		arr[0][1] = sc.nextInt();
		arr[0][2] = sc.nextInt();
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		for(int i=1;i<N;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
			dp[i][0] = arr[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
			dp[i][1] = arr[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
			dp[i][2] = arr[i][2]+Math.min(dp[i-1][1],dp[i-1][0]);
			
		}
		int min = Math.min(dp[N-1][0], dp[N-1][1]);
		min = Math.min(min, dp[N-1][2]);
		System.out.println(min);
	}
}
