package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution7206_2 {
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[100000];
		Arrays.fill(arr, -1);
		for(int i=0;i<10;i++) arr[i] = 0;
		for (int i = 10; i < 25; i++)
			arr[i] = 1;
		for (int i = 25; i < 100000; i++) {
			for (int j = 100000; j >= 10; j = j / 10) {
				if (i < j)
					continue;
				arr[j] = Math.max(mul(i%j, 1, i/j), mul(i%j, i/j, 0))+1;
				break;
			}			
		}
		for (int i = 0; i < N; i++) {
			System.out.println("#" + (i + 1) + " " + arr[sc.nextInt()]);
			/*t = 0;
			solve(sc.nextInt(), 0);
			System.out.println("#" + (i + 1) + " " + t);*/
		}
			
	}

	static int mul(int x, int n, int y) {
		int min = 1;
		if(x*n*y<10) return 0;		
		if(x < 10) {
			return Math.max(arr[n*(y*10+x)], arr[(n*(y*x) )]);
			//return Math.max(smul(n*(y*10+x))+1, smul(n*(y*x) )+1);			
		}
		if(arr[x*n*y] != -1) return arr[x*n*y];
		for (int i = 100000; i >= 10; i = i / 10) {
			if( x < i) continue;
			min = Math.max(min, mul(x%i, n*y,x/i));
			min = Math.max(min, mul(x%i, n,(y*10+x/i)));
			break;
		}
		if(n*x*y == 0) return 0;
		return arr[x*n*y]=min+1;
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