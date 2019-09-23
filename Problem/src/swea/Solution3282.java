package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3282 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T;tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int [][]item = new int[N][2];
			int []max_price = new int[K+1];
			for(int i=0;i<N;i++) {
				item[i][0]=sc.nextInt();
				item[i][1]=sc.nextInt();
				for(int j=K;j>=item[i][0];j--) {
					max_price[j]=Math.max(max_price[j], max_price[j-item[i][0]]+item[i][1]);
				}
			}
			//System.out.println(Arrays.toString(max_price));
			int ans=0;
			for(int i=0;i<=K;i++) ans = Math.max(ans, max_price[i]);
			System.out.println("#"+tc+" "+ans);
		}
			
		
		
	}
}
