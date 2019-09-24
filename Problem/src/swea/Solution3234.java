package swea;

import java.util.Scanner;

public class Solution3234 {
	static boolean is_left[];
	static int N;
	static int num[];
	static boolean is_vist[];
	static long ans=0;
	static int[][] ansarr;
	//static int false_num, true_num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			is_left = new boolean[N];
			num = new int[N];
			int sum = 0;
			for(int i=0;i<N;i++) {
				num[i]=sc.nextInt();
				sum+=num[i];
			}
			ans =0;
			ansarr = new int[(1<<N)][sum+1];
			select_num(0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	static void select_num(int now) {		
		if(now == N) {
			int false_num=0, true_num=0;
			for(int i=0;i<N;i++) {
				if(is_left[i]) true_num+=num[i];
				else false_num+=num[i];
			}
			is_vist = new boolean[N];
			if(true_num > false_num) count_true(0, 0);
			else if(true_num > false_num) count_false(0, 0);
			else {
				count_true(0, 0);
				count_false(0, 0);
			}
			
			return;
		}
		is_left[now]=true;
		select_num(now+1);
		is_left[now]=false;
		if(now != 0) select_num(now+1);
	}
	static void count_true(int cnt, int sum, int idx) {
		if(sum < 0) return;
		if(cnt == N) {
			ans++;
			return;
		}
		for(int i=0;i<N;i++) {
			int idx=0;
			
			if()
		}
		for(int i=0;i<N;i++) {
			if(!is_vist[i]) {
				is_vist[i]=true;
				if(is_left[i]) count_true(cnt+1, sum+num[i]);
				else count_true(cnt+1, sum-num[i]);
				
				is_vist[i]=false;
			}
		}
		
	}
	static void count_false(int cnt, int sum) {
		if(sum > 0) return;
		if(cnt == N) {
			ans++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(!is_vist[i]) {
				is_vist[i]=true;
				if(is_left[i]) count_false(cnt+1, sum+num[i]);
				else count_false(cnt+1, sum-num[i]);
				is_vist[i]=false;
			}
		}
		
	}
	
	
	
	
}
