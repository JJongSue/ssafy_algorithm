package swea;

import java.util.Scanner;

public class Solution2117 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T;tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = N+1;
			int map[][] = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int k=K;k>=0;k--) {
						int min = 0;
						for(int y=i-k;y<=i+k;y++) {
							if(y<0 || y>=N) continue;
							for(int x=j-k;x<=j+K;x++) {
								if(x<0 || x>=N) continue;
								if(Math.abs(x-j)+Math.abs(y-i) > k) continue;
								min+=map[y][x];
							}
						}
						if( (k+1)*(k+1)+k*k <= min*M )
						ans = Math.max(min, ans);
						
					}
				}
			}			
			System.out.println("#"+tc+" "+ ans);
		}
	}
}
