package BÇü;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution3819 {
	static int arr[];
	static int dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			arr = new int[N];
			dp = new int[N];
			int max = -200000000;
			int min = 0;
			//System.out.println(max);
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
				if(i>0) {
					arr[i] += arr[i-1];
				}
				dp[i] = arr[i]-min;
				if(max < dp[i]) max = dp[i];
				if(min > arr[i]) min = arr[i];
			}
			System.out.println("#"+tc+" "+max);
			
			
		}
	}
}
