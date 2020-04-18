package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11724 {
	static int parents[];
	static int N, M;
	static int find_set(int now) {
//		System.out.println(now);
		if(parents[now] == 0) return now;
		return parents[now] = find_set(parents[now]);
	}
	static void union(int x, int y) {
		int px = find_set(x);
		int py = find_set(y);
		if(px == py) return;
		parents[px] = y;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}
		int cnt = 0;
		for(int i=1;i<=N;i++) if(parents[i] == 0) cnt++;
		System.out.println(cnt);
	}
}
