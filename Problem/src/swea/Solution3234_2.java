package swea;

import java.util.Scanner;

public class Solution3234_2 {
	static int N;
	static int [][]map;
	static int []num;
	static boolean []is_visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			map = new int[(1<<(N))][(1<<(N))];
			is_visit = new boolean[N];
			num = new int[N];
			int sum = 0;
			for(int i=0;i<N;i++) {
				num[i]=sc.nextInt();				
			}
			find_ans(0,0,0);
			System.out.println("#"+tc+" "+map[0][0]);
		}
	}
	static int find_ans(int left, int right, int sum) {
		if(left+right == (1<<(N))-1) return 1;
		if(map[left][right] > 0) return map[left][right];
		int ans_tmp = 0;
		for(int i=0;i<N;i++) {
			if(!is_visit[i]) {
				is_visit[i]=true;
				if(sum - num[i] < 0) {
					ans_tmp += find_ans(left|(1<<i), right, sum+num[i]);
				}else {
					ans_tmp += find_ans(left|(1<<i), right, sum+num[i]);
					ans_tmp += find_ans(left, right|(1<<i), sum-num[i]);
				}
				is_visit[i]=false;
				
			}
		}
		
		
		return map[left][right]=ans_tmp;
	}
}
