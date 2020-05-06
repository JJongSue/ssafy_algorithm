package boj;

import java.util.Scanner;

public class Main18883 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=1;j<=M;j++) {
				sb.append((i*M+j));
				if(j != M) sb.append(" ");
			}sb.append("\n");
		}
		System.out.println(sb);
	}
}
