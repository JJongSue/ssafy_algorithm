package swea;

import java.util.Scanner;

public class Solution6789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			long N = sc.nextLong();
			long cnt = 0;
			while(N != 2) {				
				long tmp = (long) (Math.sqrt(N));
				if(tmp*tmp == N) {
					cnt++;
					N =  tmp;
				}else {
					cnt += ((tmp+1)*(tmp+1)-N)+1;
					N =  (tmp+1);
				}
				
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
