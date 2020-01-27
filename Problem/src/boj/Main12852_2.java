package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main12852_2 {
	static int dp[] = new int[1_000_001];
	static Queue<Integer> q = new LinkedList<Integer>();
	static Stack<Integer> st = new Stack<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp[1] = 1;
		
		q.add(1);
		
		
		end:while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				int now = q.poll();
				if(now*3 <= N && dp[now*3] == 0) {
					dp[now*3] = now;
					q.add(now*3);
				}
				if(now*2 <= N && dp[now*2] == 0) {
					dp[now*2] = now;
					q.add(now*2);
				}
				if(now+1 <= N && dp[now+1] == 0) {
					dp[now+1] = now;
					q.add(now+1);
				}
				if(dp[N] != 0) {
					break end;
				}	
			}	
		}
		//st.add(dp[N]);
		q.clear();
		int find = dp[N];
		q.add(N);
		while(find != 1) {
			q.add(find);
			find = dp[find];
		}
		q.add(1);
		System.out.println(q.size()-1);
		while(!q.isEmpty()) {
			System.out.print(q.poll()+" ");
		}
		
	}
}
