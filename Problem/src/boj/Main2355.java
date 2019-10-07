package boj;

import java.util.Scanner;

public class Main2355 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long A = sc.nextLong();
		Long B = sc.nextLong();
		Long ans = (long) -1;
		if(A < B) {
			ans = (B*(B+1))/2 - (A-1)*A/2;
		}else {
			ans = (A*(A+1))/2 - (B-1)*B/2;
		}
		System.out.println(ans);
	}
}
