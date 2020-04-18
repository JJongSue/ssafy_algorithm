package boj;

import java.util.Scanner;

public class Main11727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N == 1) {
			System.out.println(1);
		}else if(N == 2) {
			System.out.println(3);
		}else {
			long arr[] = new long[N];
			arr[0] = 1;
			arr[1] = 3;
			for(int i=2;i<N;i++) {
				arr[i] = (arr[i-2] * 2 + arr[i-1] ) % 10_007;
			}
			System.out.println(arr[N-1]);
		}
	}
}
