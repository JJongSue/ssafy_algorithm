package boj;

import java.util.Scanner;

public class Main1085 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int dis = w - x;
		dis = Math.min(dis, h-y);
		dis = Math.min(dis, x);
		dis = Math.min(dis, y);
		System.out.println(dis);
	}
}
