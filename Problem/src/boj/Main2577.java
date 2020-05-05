package boj;

import java.util.Scanner;

public class Main2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt() * sc.nextInt() * sc.nextInt();
		String tmp = Integer.toString(a);
		int cnt[] = new int[10];
		for(int i=0;i<tmp.length();i++) {
			int ch = tmp.charAt(i) - '0';
			cnt[ch]++;
		}
		for(int i=0;i<10;i++) System.out.println(cnt[i]);
	}
}
