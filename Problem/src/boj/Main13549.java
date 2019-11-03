package boj;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main13549 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean is_visit[] = new boolean[200001];
		Queue<Integer> q = new LinkedList<Integer>();
		is_visit[N] = true;
		q.add(N);
		for(int m = N*2;m<=100000;m*=2) {
			if(m==0) break;
			if(!is_visit[m]) {
				is_visit[m] = true;
				q.add(m);
			}else break;
		}
		int time = 0;
		if(N >= M) System.out.println(N-M);
		else {
			while(!q.isEmpty()) {
				if(is_visit[M]) break;
				int size = q.size();
				//Queue<Integer> tmpq = new LinkedList<Integer>();
				for(int s=0;s<size;s++) {
					int tmp = q.poll();
					
					if(tmp-1>=0 && !is_visit[tmp-1]) {						
						is_visit[tmp-1] = true;
						q.add(tmp-1);
						for(int m = (tmp-1)*2;m<=100000;m*=2) {
							if(m==0) break;
							if(!is_visit[m]) {
								is_visit[m] = true;
								q.add(m);
							}else break;
						}
					}
					if(tmp+1<=100000 && !is_visit[tmp+1]) {
						is_visit[tmp+1] = true;
						for(int m = (tmp+1)<<1;m<=100000;m*=2) {
							if(m==0) break;
							if(!is_visit[m]) {
								is_visit[m] = true;
								q.add(m);
							}
							else break;
						}
						q.add(tmp+1);
					}
					
					
					
				}
				time++;
				
			}
			System.out.println(time);
			
		}
	}
}
