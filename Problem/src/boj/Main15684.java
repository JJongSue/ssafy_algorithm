package boj;

import java.util.Scanner;

public class Main15684 {
	static int N, H, M;
	static int [][]arr;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		H = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][M];
		for(int h=0;h<H;h++) {
			int i=sc.nextInt();
			int j = sc.nextInt();
			arr[i-1][j-1]=1;
			arr[i-1][j]=-1;
		}
		
		go(0);
		select(0, 0);
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}
	
	static void select(int now, int cnt) {
		if(answer == 0) return;
		if(answer != Integer.MAX_VALUE && cnt >= answer) return;
		if(cnt == 3) {
			go(cnt);
			return;
		}
		if(now == N*M) {
			go(cnt);
			return;
		}
		select(now+1, cnt);
		if(arr[now/M][now%M] != 0) {
			boolean is_ok = true;
			if( now%M-1>=0 && arr[now/M][now%M-1]!=0 ) is_ok=false;
			if( now%M+1<M && arr[now/M][now%M+1]!=0 ) is_ok=false;
			if(is_ok) {
				arr[now/M][now%M] = 1;
				if(now%M+1<M) {
					arr[now/M][now%M+1] = -1; 
				}
				
				arr[now/M][now%M] = 0;
				if(now%M+1<M) {
					arr[now/M][now%M+1] = 0; 
				}
			}
		}/*else {
			select(now+1, cnt);
		}*/
	}
	
	static void go(int cnt) {
		for(int j=0;j<M;j++) {
			int now = j;
			for(int i=0;i<N;i++) {
				now += arr[i][now];
			}
			if(now != j) {
				
				return;
			}
		}
		if(answer > cnt) answer = cnt;
		
		return;
			
	}
}
