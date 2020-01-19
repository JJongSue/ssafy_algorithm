package boj;

import java.util.Scanner;

public class Main4811 {
	static long dp[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dp = new long[31][31];
		for(int i=0;i<31;i++) {
			for(int j=0;j<31;j++) {
				dp[i][j] = -1;
			}
		}
		while(true) {
			int a = sc.nextInt();
			if(a==0) break;
			System.out.println(count(a,0));
		}
		
	}
	static long count(int w, int h) {
		if(dp[w][h] != -1) return dp[w][h];
		if(w == 0 && h==0) return dp[0][0]=1;
		if(h == 0) return dp[w-1][1]=count(w-1, 1);
		if(w == 0) return dp[w][h]=1;
		dp[w-1][h+1] = count(w-1, h+1);
		dp[w][h-1] = count(w, h-1);
		return dp[w-1][h+1] + dp[w][h-1];
	}
}
