package boj;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean is_visit[] = new boolean[200001];
		Queue<Integer> q = new LinkedList<Integer>();
		is_visit[N] = true;
		q.add(N);
		int time = 0;
		if(N >= M) System.out.println(N-M);
		else {
			while(!q.isEmpty()) {
				if(is_visit[M]) break;
				int size = q.size();
				for(int s=0;s<size;s++) {
					int tmp = q.poll();
					if(tmp-1>=0 && !is_visit[tmp-1]) {
						is_visit[tmp-1] = true;
						q.add(tmp-1);
					}
					if(tmp*2<=200000 && !is_visit[tmp*2]) {
						is_visit[tmp*2] = true;
						q.add(tmp*2);
					}
					if(tmp+1<=200000 && !is_visit[tmp+1]) {
						is_visit[tmp+1] = true;
						q.add(tmp+1);
					}
					
				}
				time++;
				
			}
			System.out.println(time);
			
		}
	}
}
