package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main12851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean is_visit[] = new boolean[200001];
		long cnt[] = new long[200001];
		int timeal[] = new int[200001];
		for(int i=0;i<200001;i++) timeal[i] = -1;
		Queue<Integer> q = new LinkedList<Integer>();
		is_visit[N] = true;
		q.add(N);
		int time = 0;
		timeal[N] = 0;
		cnt[N] = 1;
		if(N >= M) {
			System.out.println(N-M);
			System.out.println(1);
		}
		else {
			while(!q.isEmpty()) {
				if(is_visit[M]) break;
				int size = q.size();
				for(int s=0;s<size;s++) {
					int tmp = q.poll();
					if(tmp-1>=0 && is_visit[tmp-1] && timeal[tmp-1] == time+1) {
						cnt[tmp-1] += cnt[tmp];
					}
					if(tmp-1>=0 && !is_visit[tmp-1]) {
						is_visit[tmp-1] = true;
						q.add(tmp-1);
						timeal[tmp-1] = time+1;
						cnt[tmp-1] = cnt[tmp];						
					}
					if(tmp*2<=200000 && is_visit[tmp*2] && timeal[tmp*2] == time+1) {
						cnt[tmp*2] += cnt[tmp];
					}
					if(tmp*2<=200000 && !is_visit[tmp*2]) {
						is_visit[tmp*2] = true;
						q.add(tmp*2);
						timeal[tmp*2] = time+1;
						cnt[tmp*2] = cnt[tmp];
					}
					if(tmp*2<=200000 && is_visit[tmp+1] && timeal[tmp+1] == time+1) {
						cnt[tmp+1] += cnt[tmp];
					}
					if(tmp*2<=200000 && !is_visit[tmp+1]) {
						is_visit[tmp+1] = true;
						q.add(tmp+1);
						timeal[tmp+1] = time+1;
						cnt[tmp+1] = cnt[tmp];
					}
					
				}
				time++;
				
			}
			System.out.println(time);
			System.out.println(cnt[M]);
			
		}
	}
}
