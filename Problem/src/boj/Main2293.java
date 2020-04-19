package boj;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main2293 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int arr[] = new int[N];
		int dp[] = new int[K+1];
		dp[0] = 1;
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
			//dp[arr[i]] = 1;
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			int tmp = arr[i];
			for(int j=0;j+tmp<=K;j++) {
				dp[j+tmp] += dp[j];
			}
//			for(int j=2;j*tmp<=K;j++) {
//				dp[j*tmp] += 1;
//			}
		}
		System.out.println(dp[K]);
	}
}
