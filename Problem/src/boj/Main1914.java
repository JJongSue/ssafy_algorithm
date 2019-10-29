package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1914 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if(N <= 20) {
			top(N, 1, 3);
			System.out.println(ans);
			System.out.println(sb);
		}else {
			BigInteger ii = BigInteger.valueOf(3);
			
			for(int i=3;i<=N;i++) 
				ii = ii.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
			System.out.println(ii);
		}
		
	}
	
	static void top(int size, int now, int want) {
		
		if(size == 1) {
			ans++;
			sb.append(now).append(" ").append(want).append("\n");
			return;
		}
		top(size-1, now, 6-now-want);
		top(1, now, want);
		top(size-1, 6-now-want, want);
	}
	
}
