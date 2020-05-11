package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main16964 {
	static int N;
	static ArrayList<Integer> al[];
	static boolean is_visit[];
	static Stack<Integer> stack = new Stack<>();
	static int ans[];
	static boolean answer = true;
	static int ansnow = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		is_visit = new boolean[N+1];
		al = new ArrayList[N+1];
		ans = new int[N];
		
		for(int i=1;i<=N;i++) al[i] = new ArrayList<>();
		
		StringTokenizer st;
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			al[s].add(e);
			al[e].add(s);
			
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
		ansnow = 1;
		dfs(1);
		if(answer) System.out.println(1);
		else System.out.println(0);
		
	}
	static void dfs(int now) {
		if(!answer || ansnow == N) return;
		is_visit[now] = true;
		boolean all = true;
		for(int i=0;i<al[now].size();i++) {
			if(ansnow == N) return;

			if(al[now].get(i) == ans[ansnow]) {
				ansnow++;
				dfs(al[now].get(i));
				i=-1;
			}
		}
		for(int i=0;i<al[now].size();i++) {
			if(!is_visit[al[now].get(i)]) {
				answer = false;
				return;
			}
			
		}
//		if(ansnow != N) answer = false;
		
	}
}
