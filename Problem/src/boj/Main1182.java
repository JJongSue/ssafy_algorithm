package boj;

import java.util.Scanner;

public class Main1182 {
	static int ans = 0;
	static int N, S;
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) arr[i] = sc.nextInt();
		for(int k=1;k<N;k++) {
			get_num(0, 0, k, 0);
		}
		int sum = 0;
		for(int i=0;i<N;i++) sum += arr[i];
		if(sum == S) ans++;
		System.out.println(ans);
		
	}
	
	static void get_num(int now, int cnt, int K, int sum) {
		if(cnt == K) {
			if(sum == S) ans++;
			return;
		}
		if(now == N) return;
		get_num(now+1, cnt+1, K, sum+arr[now]);
		get_num(now+1, cnt, K, sum);
	}
}
