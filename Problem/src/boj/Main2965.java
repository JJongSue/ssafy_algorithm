package boj;

import java.util.Scanner;

public class Main2965 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if(c-b > b-a) {
			System.out.println(c-b-1);
		}else {
			System.out.println(b-a-1);
		}
	}
}
