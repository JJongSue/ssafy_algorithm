package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2011 {
	static String tmp;
	static int dp[];
	static final int div = 1_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tmp = br.readLine();
		if(tmp.length() == 1) {
			if(tmp.charAt(0) == '0') System.out.println(0);
			else System.out.println(1);
		}else {
			if(tmp.charAt(0) == '0') System.out.println(0);
			else {
				dp = new int[tmp.length()];
				if(tmp.charAt(1) == '0' && (tmp.charAt(0) == '1' || tmp.charAt(0) == '2')){
					dp[0] = 1;
					dp[1] = 1;
				}else if(tmp.charAt(1) == '0' && (tmp.charAt(0) > '2') ){
					dp[0] = 0;
					dp[1] = 0;
				}else if(tmp.charAt(0) == '1') {
					dp[0] = 1;
					dp[1] = 2;
				}else if(tmp.charAt(0) == '2' && !(tmp.charAt(1) > '6')) {
					dp[0] = 1;
					dp[1] = 2;
				}else {
					dp[0] = 1;
					dp[1] = 1;
				}
				
				for(int i=2;i<tmp.length();i++) {
					if(tmp.charAt(i) == '0') {
						if(tmp.charAt(i-1) == '1' || tmp.charAt(i-1) == '2') {
							dp[i] = dp[i-2];
						}else {
							break;
						}
					}else if(tmp.charAt(i-1) == '1') {
						dp[i] = (dp[i-1] + dp[i-2])%div;
					}else if(tmp.charAt(i-1) == '2' ) {
						if(tmp.charAt(i) > '6') {
							dp[i] = dp[i-1];
						}else {
							dp[i] = (dp[i-1] + dp[i-2])%div;
						}
					}else dp[i] = dp[i-1];
				}
				System.out.println(dp[tmp.length()-1]);
				
			}
		}
		
		
		
		

	}
}
