package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1600 {
	static int K, N, M;
	static int map[][];
	static int dp[][][];
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>= M || y>=N) return false;
		return true;
	}
}
