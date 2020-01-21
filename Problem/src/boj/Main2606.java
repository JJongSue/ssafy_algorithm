package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2606 {
	static int parents[];
	static int get_num(int x) {
		if(parents[x] < 0) return x;
		return parents[x] = get_num(parents[x]);
	}
	static void union(int x, int y) {
		int px = get_num(x);
		int py = get_num(y);
		parents[px] += parents[py];
		parents[py] = px;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		for(int i=1;i<=N;i++) parents[i] = -1;
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(get_num(x) != get_num(y)) union(x, y);
		}
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			if(get_num(i) == get_num(1)) cnt++;
		}
		System.out.println(cnt-1);
	}
}
