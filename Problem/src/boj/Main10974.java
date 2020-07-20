package boj;

import java.util.Scanner;

public class Main10974 {
	static boolean is_visit[];
	static int N, arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		is_visit = new boolean[N+1];
		arr = new int[N+1];
		get_num(0);
//		StringBuilder sb = new StringBuilder();
		System.out.println(sb);
	}
	
	static void get_num(int now) {
		if(now == N) {
			for(int i=0;i<N;i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(!is_visit[i]) {
				is_visit[i] = true;
				arr[now] = i;
				get_num(now+1);
				is_visit[i]= false;
			}
		}
	}
}
