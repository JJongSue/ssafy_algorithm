package boj;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main13913 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean is_visit[] = new boolean[200001];
		int parents[] = new int[200001];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<200001;i++) {
			parents[i] = -1;
		}
		//parents[N] = 0;
		is_visit[N] = true;
		q.add(N);
		int time = 0;
		if(N >= M) {
			System.out.println(N-M);
			for(int i=N;i>=M;i--) {
				System.out.print(i+" ");
			}
		}
		else {
			
			while(!q.isEmpty()) {
				if(is_visit[M]) break;
				int size = q.size();
				for(int s=0;s<size;s++) {
					int tmp = q.poll();
					if(tmp-1>=0 && !is_visit[tmp-1]) {
						is_visit[tmp-1] = true;
						q.add(tmp-1);
						parents[tmp-1] = tmp;
					}
					if(tmp*2<=200000 && !is_visit[tmp*2]) {
						is_visit[tmp*2] = true;
						parents[tmp*2] = tmp;
						q.add(tmp*2);
					}
					if(tmp+1<=200000 && !is_visit[tmp+1]) {
						is_visit[tmp+1] = true;
						parents[tmp+1] = tmp;
						q.add(tmp+1);
					}
					
				}
				time++;
				
			}
			System.out.println(time);
			int pt = M;			
			Stack<Integer> stack = new Stack<Integer>();
			while(parents[pt] != -1) {
				stack.add(parents[pt]);
				pt = parents[pt];
			}
			while(!stack.isEmpty()) {
				System.out.print(stack.pop()+" ");
			}
			System.out.print(M+" ");
			
		}
	}
}
