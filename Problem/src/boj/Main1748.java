package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String tmp = "";
		long ans = 0;
		int cnt = 0;
		int iter = 1;
		for(int i=1;i<=N;i++) {
			if(i == iter) {
				cnt++;
				iter*=10;
			}
			ans += cnt;
			//bi.add(BigInteger.valueOf(String.valueOf(i).length()));
			//ans += String.valueOf(i).length();
			//tmp += String.valueOf(i);
		}
		System.out.println(ans);
		//System.out.println(bi);
	}
}
