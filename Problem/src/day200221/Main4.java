package day200221;

import java.util.Scanner;

public class Main4 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		top(N, 1, 3);
		System.out.println(ans);
		System.out.println(sb);
		
		
	}
	
	static void top(int size, int now, int want) {
		
		if(size == 1) {
			ans++;
			return;
		}
		top(size-1, now, 6-now-want);
		top(1, now, want);
		top(size-1, 6-now-want, want);
	}
	
}