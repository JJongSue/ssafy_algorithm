package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1260 {
	static int N, M, start;
	static int ans[];
	static boolean is_go[][];
	static boolean is_visit[];
	static Queue<Integer> q = new LinkedList();
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[N];
		start = Integer.parseInt(st.nextToken());

		is_visit = new boolean[N + 1];
		is_go = new boolean[N+1][N+1];


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			is_go[s][e] = true;
			is_go[e][s] = true;
		}
		stack.add(start);

//		is_visit[start] = true;
//		sb.append(start);
		stack.add(start);
		while (!stack.isEmpty()) {
			int tmp = stack.pop();
			if(is_visit[tmp]) continue;
			is_visit[tmp] = true;
			sb.append(tmp).append(" ");
			for(int i=N;i>0;i--) {
				if(is_go[tmp][i] && !is_visit[i]) {
					stack.add(i);
				}
			}
			
		}
		sb.append("\n");
		is_visit = new boolean[N+1];
		q.add(start);
		while(!q.isEmpty()) {
			int tmp = q.poll();
			if(is_visit[tmp]) continue;
			is_visit[tmp] = true;
			sb.append(tmp).append(" ");
			for(int i=1;i<=N;i++) {
				if(is_go[tmp][i] && !is_visit[i]) {
					q.add(i);
				}
			}
		}
		
		System.out.println(sb);
		

	}


}
