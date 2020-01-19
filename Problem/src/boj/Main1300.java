package boj;

import java.util.Scanner;

public class Main1300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		long L = 1;
		long R = M;
		long mid = (L+R) / 2;
		long ans = 0;
		int cnt = 0;
		while(L <= R) {
			cnt = 0;
			mid = (L + R) / 2;
			//System.out.println(L+" " + R);
			for(int i=1;i<=N;i++) {
				if(cnt > M || i > mid) break;
				cnt += Math.min(N, mid/i);
			}
			if(cnt >= M) {
				ans = mid;
				R = mid-1;
			}else {
				L = mid+1;
			}
		}
//		if(ans == 0) System.out.println(1);
//		else System.out.println(ans);
		System.out.println(ans);
		
	}
}
