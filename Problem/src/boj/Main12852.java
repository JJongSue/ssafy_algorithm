package boj;

import java.util.Scanner;

public class Main12852 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		//sb.append(N).append(" ");
		int cnt = 0;
		while(N != 1) {
			sb.append(N).append(" ");
			if(N > 8) {
				if(N % 3 == 0) {
					N = N/3;
				}else {
					N--;
				}
			}else {
				if(N % 3 == 0) {
					N = N/3;
				}else if(N%2 == 0) {
					N = N/2;
				}else {
					N--;
				}
			}
			cnt++;
		}
		sb.append(1);
		System.out.println(cnt);
		System.out.println(sb);
	}
}
