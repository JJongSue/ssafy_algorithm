package swea;

import java.util.HashMap;
import java.util.Scanner;

public class Solution5607 {
	static HashMap<pair, Integer> hm;
	static class pair{
		int x;
		int y;		
	}
	static final int div = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long fac[] = new long[1000001];
		fac[0] = 1;
		fac[1] = 1;
		for(int i=2;i<1000001;i++) {
			fac[i] = (fac[i-1]*i)%div;
		}
		for(int tc = 1 ; tc<=T; tc++) {			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if(M == 0 || N==M) System.out.println("#"+tc+" "+1);
			else if(M == 1) System.out.println("#"+tc+" "+N);
			else {
				long ans = fac[N];
				long bt = fermat((fac[N-M]*fac[M])%div, div-2);
				ans = (bt*ans)%div;
				System.out.println("#"+tc+" "+ans);
			}
		}
	}
	
	private static long fermat(long n, int x) {
        if (x == 0) return 1;
        long tmp = fermat(n, x / 2);
        long ret = (tmp * tmp) % div;
        if (x % 2 == 0) return ret;
        else return (ret * n) % div;
    }
}
