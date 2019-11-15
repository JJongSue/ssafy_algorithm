package boj;

import java.util.Scanner;

public class Main2661 {
	static int N;
	static int arr[];
	static boolean is_end = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		find_num(1);
		for(int i=1;i<=N;i++) System.out.print(arr[i]);
	}
	
	
	static void find_num(int now) {
		if(now == N+1) {
			is_end = true;
			return;
		}
		for(int i=1;i<=3;i++) {
			arr[now] = i;
			boolean ok = true;
			for(int j=1;j<=now/2;j++) {
				int cnt = 0;
				for(int k=0;k<j;k++) {
					if( arr[now-k] == arr[now-j-k] ) cnt++;
				}
				if(cnt == j) {
					ok=false;
					break;
				}
			}
			if(ok) find_num(now+1);
			if(is_end) return;
		}
	}
}
