package swea;

import java.util.Scanner;

public class Solution7206 {
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[100000];
		for (int i = 10; i < 25; i++)
			arr[i] = 1;
		for (int i = 25; i < 100000; i++) {
			mul(i,1,0);
		}
		for (int i = 0; i < N; i++) {
			t = 0;
			solve(sc.nextInt(), 0);
			System.out.println("#" + (i + 1) + " " + t);
		}
			
	}

	static int find(int x) {
		int min = 1;
		if (arr[x] != 0)
			return arr[x];
		for (int i = 100000; i >= 10; i = i / 10) {
			if (x < i)
				continue;
			min = Math.max(min, arr[(x / i) * (find(x % i))] + 1);
		}

		return arr[x] = min;
	}

	static int mul(int x, int n, int y) {
		int min = 1;
		if(x == 0) return arr[n*y]+1;
		for (int i = 100000; i >= 10; i = i / 10) {
			if( x < i) continue;
			min = Math.max(min, mul(x%i, n*y,x/i));
			min = Math.max(min, mul(x%i, n,(y*10+x/i)));
		}
		return arr[x*n*y]=min;
	}
	static int t = 0;
	static void solve(int N, int cnt) {
		if(N < 10) {
			t = Math.max(t, cnt);
			return;
		}
		if(N>=10) {
			solve(N/10 * (N%10), cnt+1);
			
		}
		if(N>=100) {
			solve(N/100 * (N%100), cnt+1);
			solve(N/100 * (N%100/10) * (N%10), cnt+1);
			
		}
		if(N>= 1000) {
			solve(N/1000*(N%1000), cnt+1);
			solve(N/1000*(N%1000/100)*(N%100), cnt+1);
			solve(N/1000*(N%1000/10)*(N%10), cnt+1);
			solve(N/1000*(N%1000/100)*(N%100/10)*(N%10), cnt+1);
			
			
		}
		if(N>=10000) {
			solve(N/10000* (N%10000), cnt+1);
			solve(N/10000* (N%10000/10)*(N%10), cnt+1);
			solve(N/10000* (N%10000/100)*(N%100), cnt+1);
			solve(N/10000* (N%10000/1000)*(N%1000), cnt+1);
			solve(N/10000* (N%10000/1000)*(N%1000/100)*(N%100), cnt+1);
			solve(N/10000* (N%10000/1000)*(N%1000/10)*(N%10), cnt+1);
			solve(N/10000* (N%10000/100)*(N%100/10)*(N%10), cnt+1);
			solve(N/10000* (N%10000/1000)*(N%1000/100)*(N%100/10)*(N%10), cnt+1);
			
		}
		
		
		
		
		
		
	}
	
	

}