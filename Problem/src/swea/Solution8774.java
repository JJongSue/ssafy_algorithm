package swea;

import java.util.Scanner;

public class Solution8774 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long al[] = new long[100000001];
		al[1]=1;
		al[2]=2;
		for(int i=3;i<100000001;i++) {
			al[i] = (al[i-1]*3+1)%1000000007;
		}
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			System.out.println("#"+tc+" "+al[N]);
		}
	}
}
