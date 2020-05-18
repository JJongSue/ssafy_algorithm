package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import boj.Main9019.sta;

public class Main9252 {
	static int dp[][];
	static char ans[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		//int ans = 0;
		
		dp = new int[A.length()+1][B.length()+1];
		ans = new char[Math.min(A.length(), B.length())];
		int now = 0;
		for(int i=0;i<A.length();i++) {
			boolean first = false;
			for(int j=0;j<B.length();j++) {
				if(A.charAt(i) == B.charAt(j)) {
					dp[i+1][j+1] = dp[i][j]+1;
//					if(dp[i+1][j+1] > now && !first) {
//						ans[now] = A.charAt(i);
//						now++;
//						first = true;
//						
//					}
					
				}else {
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}
		}
		int cnt = 0;
		int where = 0;
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<=B.length();i++) {
			if(cnt < dp[A.length()][i]) {
				cnt = dp[A.length()][i];
				where = i;
			}
//			cnt = Math.max(cnt, dp[A.length()][i]);
		}
		
		int x = where;
		int y = A.length();
		while(dp[y][x] != 0 && x!=0 && y!=0) {
			if(dp[y][x] == dp[y][x-1]) {
				x--;
			}else if(dp[y][x] == dp[y-1][x]) {
				y--;
			}else {
				y--;
				x--;
				stack.add(A.charAt(y));
			}
		}
		
		
		System.out.println(cnt);
//		for(int i=0;i<now;i++) System.out.print(ans[i]);
		while(!stack.isEmpty()) System.out.print(stack.pop());
		
	}
}
