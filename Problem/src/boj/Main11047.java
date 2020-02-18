package boj;

import java.util.Scanner;

public class Main11047 {
	static int coins[];
	static int N, K;
	static int ans = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		coins = new int[N];
		for(int i=N-1;i>=0;i--) {
			coins[i] = sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			if(K == 0) break;
			if(K >= coins[i]) {
				//System.out.println(i);
				int tmp = K/coins[i];
				ans += tmp;
				K = K%coins[i];
			}
		}
		
		
		//cnt(0,0,0);
		System.out.println(ans);
	}
	
	static void cnt(int now, int sum, int ccnt) {
		if(now == N-1) {
			ans = Math.min(ans, ccnt+(K-sum));
			return;
		}
		if(sum == K) {
			ans = Math.min(ans, ccnt);
			return;
		}
		if(now == N || sum > K) return;
		if(ans < ccnt) return;
		if(coins[now] > K-sum ) cnt(now+1, sum, ccnt);
		else {
			for(int i=(K-sum)/coins[now];i>=0;i--) {
				cnt(now+1, sum+coins[now]*i, ccnt+i);
			}
		}
		
	}
}
