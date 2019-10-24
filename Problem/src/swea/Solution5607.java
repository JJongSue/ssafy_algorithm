package swea;

import java.util.HashMap;
import java.util.Scanner;

public class Solution5607 {
	static HashMap<pair, Integer> hm;
	static class pair{
		int x;
		int y;		
	}
	static final long div = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc<=T; tc++) {
			hm = new HashMap<>();
			int N = sc.nextInt();
			int M = sc.nextInt();
			if(M == 0 || N==M) System.out.println("#"+tc+" "+1);
			else if(M == 1) System.out.println("#"+tc+" "+N);
			else {
				long ans = 1;
				if(M>N/2) M=N/2-M;
				for(int i=M;i<N;i++) {
					ans+=i;
					ans = ans % div;
				}
				System.out.println("#"+tc+" "+ans);
			}
		}
	}
	
	static int NC(int n, int c) {
		if(c == 1) return n;
		if(n == c || c == 0) return 1;
		if(hm.containsKey(key))
		return NC(n-1,c)+NC(n-1,c-1);
	}
}
