package boj;

import java.util.Scanner;

public class Main18291 {
	static final Long MAX = (long) (1_000_000_000 + 7);
	static long ans = 1;
	static long ansmap[] = new long[1_000_001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int max = 2;
		
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			if(N == 1 || N == 2) System.out.println(1);
			else {
				System.out.println(get_num(2, N-2));
			}
		}
		
	}
	
	static long get_num(int x, int N) {
		if(N==1) return x%MAX;
		if(N==0) return 1;
		if(N%2 == 0) {
			long number = get_num(x, N/2);
			return (number*number)%MAX;
		}else {
			long number = get_num(x, N/2);
			return (((number*number)%MAX)*x)%MAX;
		}
	}
}
