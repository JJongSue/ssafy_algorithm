package jungol;

import java.util.Scanner;

public class Main1103 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int T = sc.nextInt();
		int arr[][] = new int[T][2];
		for(int i=0;i<T;i++) {
			int tmp = sc.nextInt();
			if(tmp == 1) {
				arr[i][1] = 0;
				arr[i][0] = sc.nextInt();
			}else if(tmp == 2) {
				arr[i][1] = N;
				arr[i][0] = sc.nextInt();
			}else if(tmp == 3) {
				arr[i][1] = sc.nextInt();
				arr[i][0] = 0;
			}else if(tmp == 4) {
				arr[i][1] = sc.nextInt();
				arr[i][0] = M;
			}
			/* arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt(); */
			//arr[i][2] = sc.nextInt();
		}
		int tmp = sc.nextInt();
		int x=0, y=0;
		if(tmp == 1) {
			y= 0;
			x = sc.nextInt();
		}else if(tmp == 2) {
			y = N;
			x = sc.nextInt();
		}else if(tmp == 3) {
			y = sc.nextInt();
			x = 0;
		}else if(tmp == 4) {
			y = sc.nextInt();
			x = M;
		}		
		
		int ans = 0;
		for(int i =0;i<T;i++) {
			int dy = Math.abs(arr[i][1] - y);
			int dx = Math.abs(arr[i][0] - x);
			if(dy == N) {
				ans += N;
				ans += Math.min(arr[i][0]+x, M-arr[i][0]+M-x);				
			}else if(dx == M) {
				ans += M;
				ans += Math.min(arr[i][1]+y, N-arr[i][1]+N-y);
			}else {
				ans += (dx+dy);
			}
			//System.out.println(i+" "+dx+" "+dy);
		}
		System.out.println(ans);
	}
}
