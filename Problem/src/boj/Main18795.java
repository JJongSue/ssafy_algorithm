package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main18795 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		Scanner sc = new Scanner(System.in);
		long ans = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
//		int N = sc.nextInt();
//		int M = sc.nextInt();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
//			ans += Long.parseLong(st.nextToken());
			ans += Integer.parseInt(st.nextToken());
//			ans += sc.nextLong();
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
//			ans += Long.parseLong(st.nextToken());
			ans += Integer.parseInt(st.nextToken());
//			ans += sc.nextLong();
		}
		System.out.println(ans);
	}
}
