package swea;

import java.util.Scanner;

public class Solution3752 {
	static int N;
	static int arr[];
	static boolean is_use[];
	static boolean is_visit[];
	static boolean is_gosum[][];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			for(int i=0;i<N;i++) arr[i] = sc.nextInt();
			is_use = new boolean[N*100+1];
			is_visit = new boolean[N];
			is_gosum = new boolean[N][N*100+1];
			ans = 0;
			find(0,0);
			System.out.println("#"+tc+" "+ans);
			
		}
	}

	static void find(int cnt, int sum) {
		if(cnt == N) {
			if(!is_use[sum]) ans++;
			is_use[sum]=true;			
			return;
		}
		if(!is_gosum[cnt][sum]) {
			find(cnt+1,sum+arr[cnt]);				
			find(cnt+1,sum);
			is_gosum[cnt][sum]=true;
		}
		
		
	}
}
