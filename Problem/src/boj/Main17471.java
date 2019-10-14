package boj;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main17471 {
	static int parents[];
	static int N;
	static boolean []select, is_visit;
	static ArrayList<Integer> []arr;
	static int[] peo;
	static int output;
	static int find_set(int x) {
		if(parents[x] == x) return x;
		//while(parents[x] == x) x = parents[x];
		return parents[x] = find_set(parents[x]);
	}
	static void union(int x, int y) {
		int py = find_set(y);
		int px = find_set(x);
		if(px != py) {
			parents[py] = px;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new ArrayList[N+1];
		peo = new int[N+1];
		output = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			arr[i] = new ArrayList<>();
			peo[i] = sc.nextInt();
		}
		
		
		
		for(int i=1;i<=N;i++) {
			int M = sc.nextInt();
			//parents[i] = i;
			for(int j=0;j<M;j++) arr[i].add(sc.nextInt());
		}
		for(int i=1;i<=(N/2);i++) {
			select = new boolean[N+1];
			comb(1, 0, i);
		}
		if(output == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(output);
		
	}
	static void comb(int now, int cnt, int limit) {
		if(cnt == limit) {
			is_visit = new boolean[N+1];
			ArrayList<Integer> answer = new ArrayList<>();
			for(int i=1;i<=N;i++) {
				if(is_visit[i]) continue;
				answer.add(bfs(i, 0, select[i]));
				if(answer.size() == 3) return;
			}
			if(answer.size() == 2) {
				int tmp = Math.abs(answer.get(0)-answer.get(1));
				if(output > tmp) output = tmp;				
			}
			return;
		}
		if(now > N) return;
		comb(now+1, cnt, limit);
		select[now] = true;
		comb(now+1, cnt+1, limit);
		select[now] = false;
		
		
		
	}
	
	static int bfs(int now, int ans, boolean tf) {
		is_visit[now] = true;
		int tmp = 0;
		for(int i=0;i<arr[now].size();i++) {
			if(tf == select[arr[now].get(i)] && !is_visit[arr[now].get(i)]) {
				//is_visit[arr[now].get(i)] = true;
				tmp += bfs(arr[now].get(i), ans, tf);
			}
		}
		return tmp+ans+peo[now];
		
	}
}
