package boj;

import java.util.Scanner;

public class Main15652 {
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int arr[] = new int[M];
		get_num(1, 0, arr);
	}
	static void get_num(int x, int cnt, int arr[]) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				System.out.print(arr[i] + " ");
			}System.out.println();
			return;
		}
		for(int i=x;i<=N;i++) {
			arr[cnt] = i;
			get_num(i, cnt+1 , arr);
		}
	}
}
