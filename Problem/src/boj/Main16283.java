package boj;

import java.util.Scanner;

public class Main16283 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int w = sc.nextInt();
		int x = -1;
		int y = -1;
		for(int i=1;i<n;i++) {
			if( a*i+b*(n-i) == w ) {
				if(x == -1 ) {
					x = i;
					y = n-i;
				}else {
					x=-1;
					y=-1;
					break;
				}
			}
		}
		if(x==-1) {
			System.out.println(-1);
		}else {
			System.out.println(x + " "+ y);
		}
	}
}
