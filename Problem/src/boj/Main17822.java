package boj;

import java.util.Scanner;

public class Main17822 {
	static int N, M, T;
	static int arr[][];
	static int rotate[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		arr = new int[N+1][M];
		for(int i=1;i<=N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<T;i++) {
			r(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		int sum = 0;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<M;j++) {
				
			}
		
	}
	}
	
	
	
	static void r(int x, int d, int k) {
		for(int i=1;i<=N;i++) {
			if(i%x != 0) continue;
			if(d == 0) {
				for(int j=0;j<k;j++) {
					int tmp = arr[i][M-1];
					for(int l=M-1;l>0;l--) {
						arr[i][l] = arr[i][l-1];
					}
					arr[i][0] = tmp;
				}
				
			}else {
				for(int j=0;j<k;j++) {
					int tmp = arr[i][0];
					for(int l=0;l<M-1;l--) {
						arr[i][l] = arr[i][l+1];
					}
					arr[i][M-1] = tmp;
				}
			}
		}
		int copymap[][] = new int[N+1][M];
		for(int i=1;i<=N;i++) {
			for(int j=0;j<M;j++) {
				copymap[i][j] = arr[i][j];
			}
		}
		boolean is = false;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<M;j++) {
				if(j-1>=0) {
					if(arr[i][j] != 0 && arr[i][j] == arr[i][j-1]) {
						is=true;
						copymap[i][j] =0;
						copymap[i][j-1] =0;
					}
				}
				if(j+1<M) {
					if(arr[i][j] != 0 && arr[i][j] == arr[i][j+1]) {
						is=true;
						copymap[i][j] =0;
						copymap[i][j+1] =0;
					}
				}
				
			}
		}
		
		for(int j=0;j<M;j++) {
			for(int i=1;i<=N;i++) {
				if(i-1>=1) {
					if(arr[i][j] != 0 && arr[i][j] == arr[i-1][j]) {
						is=true;
						copymap[i-1][j] =0;
						copymap[i][j] =0;
					}
				}
				if(i+1<=N) {
					if(arr[i][j] != 0 && arr[i][j] == arr[i+1][j]) {
						is=true;
						copymap[i+1][j] =0;
						copymap[i][j] =0;
					}
				}
			}
		}
		
		if(!is) {
			int cnt = 0;
			int sum1 = 0;
			for(int i=1;i<=N;i++) {
				for(int j=0;j<M;j++) {
					if(copymap[i][j] != 0) {
						cnt++;
						sum1 += copymap[i][j];
					}
				}
			}
			if(cnt == 0) {
				arr = new int[N+1][M];
			}
			else {
				int avg = sum/cnt;
				for(int i=1;i<=N;i++) {
					for(int j=0;j<M;j++) {
						if(copymap[i][j] != 0) {
							if(copymap[i][j] > avg)
								copymap[i][j]--;
							else if(copymap[i][j] < avg)
								copymap[i][j]++;
						}
					}
				}
			}
		}
		arr = new int[N+1][M];
		for(int i=1;i<=N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = copymap[i][j];
				}
			}
		}
		
	
		
		
	}
}
