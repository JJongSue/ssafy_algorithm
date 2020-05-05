package boj;

import java.util.Scanner;

public class Main14888 {
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int N, map[], cnt[] = new int[4];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N];
		for(int i=0;i<N;i++) map[i] = sc.nextInt();
		cnt[0] = sc.nextInt();
		cnt[1] = sc.nextInt();
		cnt[2] = sc.nextInt();
		cnt[3] = sc.nextInt();
		do_ans(1, map[0]);
		System.out.println(max+"\n"+min);
	}
	
	static void do_ans(int now, int sum) {
		if(now == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		if(cnt[0] > 0) {
			cnt[0]--;
			do_ans(now+1,sum+map[now]);
			cnt[0]++;
		}
		
		if(cnt[1] > 0) {
			cnt[1]--;
			do_ans(now+1,sum-map[now]);
			cnt[1]++;
		}
		
		if(cnt[2] > 0) {
			cnt[2]--;
			do_ans(now+1,sum*map[now]);
			cnt[2]++;
		}
		
		if(cnt[3] > 0) {
			cnt[3]--;
			do_ans(now+1,sum/map[now]);
			cnt[3]++;
		}
		
		
		
	}
}
