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
	static java.util.ArrayList<Integer> al[];
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
		al = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			al[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			al[s].add(e);
		}
		stack.add(start);

		is_visit[start] = true;
		sb.append(start);
		stack.add(start);
		while (!stack.isEmpty()) {
			int tmp = stack.pop();
			for(int i=0;i<al[tmp].size();i++) {
				int go = al.
			}
		}

	}

}
