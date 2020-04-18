package day200326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		long mul = 1;
		long number = 0;
		long ans = 0;
		for(int i=0;i<M;i++) {
			mul *= 10;
			number = number * 10 + (str.charAt(i)-'0');
		}
		ans = number;
		for(int i=M;i<N;i++) {
			number = number * 10 - (mul * (str.charAt(i-M) - '0')) + (str.charAt(i)-'0'); 
			ans = Math.max(ans, number);
		}
		System.out.println(ans);
	}
}
