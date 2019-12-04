package boj;

import java.util.Scanner;

public class Main1057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if(b>c) {
			int tmp = b;
			b = c;
			c = tmp;
		}
		int round = 1;
		while(true) {
			if(b % 2 == 1 && c == b+1) break;
			if(b%2 == 1) b = b/2+1;
			else b = b/2;
			
			if(c%2 == 1) c = c/2+1;
			else c = c/2;
			round++;
		}
		System.out.println(round);
	}
}
