package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2011 {
	static String tmp;
	static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tmp = br.readLine();
		dp = new int[tmp.length()][2];
		int start = tmp.length()-1;
		if(tmp.charAt(0) == '0') {
			System.out.println(0);
		}
		else if(tmp.length() == 1) {
			if(tmp.charAt(0) == '0') System.out.println(0);
			else System.out.println(1);
		}else {
			if(tmp.charAt(start) == '0' &&tmp.charAt(start-1) > '2') {
				System.out.println(0);
				return;
			}
			if(tmp.charAt(start) == '0' &&tmp.charAt(start-1) == '0') {
				System.out.println(0);
				return;
			}
			if(tmp.charAt(start-1) == '2' && tmp.charAt(start) <= '6' && tmp.charAt(start)> '0') {
				System.out.println(tmp);
				dp[start-1][1] = 1;
				dp[start-1][0] = 1;
				dp[start][1] = 0;
				dp[start][0] = 1;
				
			}else if(tmp.charAt(start-1) == '2' && tmp.charAt(start) ==  '0') {
				System.out.println("20");
				dp[start-1][1] = 1;
				dp[start-1][0] = 0;
				dp[start][1] = 0;
				dp[start][0] = 0;
			}else if(tmp.charAt(start-1) == '2') {
				dp[start-1][1] = 0;
				dp[start-1][0] = 1;
				dp[start][1] = 0;
				dp[start][0] = 1;
			}else if(tmp.charAt(start-1) == '1' && tmp.charAt(start) == '0') {
				dp[start-1][0] = 0;
				dp[start-1][1] = 1;
			}
			else if(tmp.charAt(start-1) == '1' && tmp.charAt(start) != '0') {
				dp[start-1][1] = 1;
				dp[start-1][0] = 1;
				dp[start][1] = 0;
				dp[start][0] = 1;
			}
			else if(tmp.charAt(start-1) == '0') {
				
				dp[start][0] = 1;
			}
			else {
				dp[start][0] = 1;
				dp[start-1][0] = 1;
			}
//			if(tmp.charAt(start) == '0' && tmp.charAt(start-1) == '0') {
//				System.out.println(0);
//				return;
//			}
			start = start -2;
			for(int i=start;i>=0;i--) {
				char now = tmp.charAt(i);
				if(now == '0' && tmp.charAt(i+1) == '0') {
					dp[0][0] =0;
					dp[0][1] = 0;
					break;
				}
				if(now == '0') {
					continue;
				}
				if(now == '1') {
					dp[i][0] = (dp[i+1][1] + dp[i+1][0])%1000000;
					dp[i][1] = (dp[i+2][0] + dp[i+2][1])%1000000;
				}else if(now == '2') {
					if(tmp.charAt(i+1) <= '6') {
						dp[i][0] = (dp[i+1][1] + dp[i+1][0])%1000000;
						dp[i][1] = (dp[i+2][0] + dp[i+2][1])%1000000;
					}else {
						dp[i][0] = (dp[i+1][1] + dp[i+1][0])%1000000;
					}
				}else {
					dp[i][0] = (dp[i+1][1] + dp[i+1][0])%1000000;
				}
				
			}
			int ans = (dp[0][0] + dp[0][1]) %1000000;
			System.out.println(ans);
			
		}
		
//		for(int i=0;i<tmp.length();i++) {
//			System.out.print(dp[i][0] + " ");
//		}System.out.println();
//		for(int i=0;i<tmp.length();i++) {
//			System.out.print(dp[i][1] + " ");
//		}System.out.println();
	}
}
