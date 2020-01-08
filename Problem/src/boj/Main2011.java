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
		if(tmp.charAt(start) == '0') {
			
		}
		dp[tmp.length()-1][0] = 1;
		for(int i=tmp.length()-1;i>=0;i--) {
			
		}
	}
}
