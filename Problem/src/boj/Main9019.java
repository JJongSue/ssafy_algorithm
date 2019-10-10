package boj;

import java.util.Scanner;

public class Main9019 {
	static String answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1;tc<=T;tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
		}
	}
	
	static void do_go(int []a, int []b, String ans) {
		boolean is_ok = true;
		for(int i=0;i<4;i++) {
			if(a[i] != b[i]) {
				is_ok = false;
				break;
			}
		}
		if(is_ok) {
			answer = ans;
			return;
		}
		dD(a, b, ans);
		dS(a, b, ans);
		dL(a, b, ans);
		dR(a, b, ans);
		
	}
	static void dD(int []a, int []b, String ans) {
		
	}
	static void dS(int []a, int []b, String ans) {
		
	}
	static void dL(int []a, int []b, String ans) {
		
	}
	static void dR(int []a, int []b, String ans) {
		
	}

}
