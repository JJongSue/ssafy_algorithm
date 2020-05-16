package boj;

import java.util.Scanner;

public class Main2629 {
	static int N, M;
	static short is_ok[][];
	static short arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new short[N];
		is_ok = new short[N][300_000];
		
		for(int i=0;i<N;i++) arr[i] = sc.nextShort();
		
		M = sc.nextInt();
		for(int i=0;i<M;i++) {
			int sum = sc.nextInt();
			short ans = go(0,150_000 - sum);
			if(ans == 1) System.out.print("Y ");
			else System.out.print("N ");
		}
			
	}
	
	static short go(int now, int sum) {
		if(now == N) {
			if(sum == 150_000) return 1;
			return -1;
		}
		if(sum == 150_000) return 1;
		if(is_ok[now][sum] != 0) return is_ok[now][sum];
//		if()
		short a = go(now+1, sum+arr[now]);
		if(a == 1) return is_ok[now][sum] = 1;
		a = go(now+1, sum-arr[now]);
		if(a == 1) return is_ok[now][sum] = 1;
		
		a = go(now+1, sum);
		if(a == 1) return is_ok[now][sum] = 1;
		
		return is_ok[now][sum]=-1;
	}
}
