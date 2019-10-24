package boj;

import java.util.Scanner;

public class Main1043 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int tcnt = sc.nextInt();
		boolean is_t[] = new boolean[N+1];
		for(int i=0;i<tcnt;i++) {
			int tmp =sc.nextInt();
			is_t[tmp] = true;
		}
		int ans = 0;
		for(int i=0;i<M;i++) {
			boolean is_cnt = true;
			int peo = sc.nextInt();
			for(int j=0;j<peo;j++) {
				int tmp = sc.nextInt();
				if(is_t[tmp]) is_cnt=false;
			}
			if(is_cnt) ans++;
		}
		System.out.println(ans);
	}
}
