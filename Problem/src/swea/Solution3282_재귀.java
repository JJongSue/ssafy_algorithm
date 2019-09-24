package swea;

import java.util.Scanner;

public class Solution3282_재귀 {
	static int item[][];
	static int N;
	static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T;tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			item = new int[N][2];
			int []max_price = new int[K+1];
			for(int i=0;i<N;i++) {
				item[i][0]=sc.nextInt();
				item[i][1]=sc.nextInt();
				for(int j=K;j>=item[i][0];j--) {
					max_price[j]=Math.max(max_price[j], max_price[j-item[i][0]]+item[i][1]);
				}
			}
			int ans=0;
			for(int i=0;i<=K;i++) ans = Math.max(ans, max_price[i]);
			System.out.println("#"+tc+" "+ans);
		}
	}
	static void find(int now, int v, int c) {
		if(now == N) {
			
		}
	}
}
