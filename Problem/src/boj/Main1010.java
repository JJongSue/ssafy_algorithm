package boj;

import java.util.Scanner;

public class Main1010 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			if(N == 0) System.out.println(0);
			else if(N == 1) System.out.println(M);
			else if(N == M) System.out.println(1);
			else {
				long[][] arr = new long[N+1][M+1];
				for(int i=1;i<=M;i++) arr[1][i] = i;
				for(int i=2;i<=N;i++) {
					for(int j=i;j<=M;j++) {
						arr[i][j] = arr[i-1][j-1]+arr[i][j-1];
					}
				}
				System.out.println(arr[N][M]);
			}
		}
		
		
	}
}
