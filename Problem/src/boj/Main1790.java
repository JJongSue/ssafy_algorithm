package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1790 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		if(K > 788888898) System.out.println(-1);
		else {
			
		}
		int ii=-1;
		String tmp = "";
		long ans = 0;
		int cnt = 0;
		int iter = 1;
		K--;
		for(int i=1;i<=N;i++) {
			if(i == iter) {
				cnt++;
				iter*=10;
			}
			K -= cnt;			
			if(K<0) {
				K += cnt;
				String s= String.valueOf(i);
				while(K>=0) {
					K--;
					ii++;
				}
				System.out.println(s.charAt(ii));
				break;
			}
			//bi.add(BigInteger.valueOf(String.valueOf(i).length()));
			//ans += String.valueOf(i).length();
			//tmp += String.valueOf(i);
		}
		if(ii == -1) System.out.println(-1);
		//System.out.println(ans);
		//System.out.println(bi);
	}
}
