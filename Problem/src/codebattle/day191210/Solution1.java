package codebattle.day191210;

import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int count[] = new int[10001];
			for(int i=0;i<N;i++) {
				int tmp = sc.nextInt();
				count[tmp]++;				
			}
			int ans = 0;
			for(int i=0;i<10001;i++) {
				int tmp = 0;
				for(int k=0;k<=K;k++) {
					//if(i-k>0 && count[i-k]!=0) ans+=count[i];
					if(i+k<10001 && count[i+k]!=0) tmp+=count[i+k];
					
				}
				ans = Math.max(ans, tmp);
			}
			System.out.println("#"+tc+" "+ans);
			
		}
	}
}
