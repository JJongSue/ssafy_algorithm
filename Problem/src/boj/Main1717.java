package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1717 {
	static int parents[];
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		for(int i=0;i<=N;i++) parents[i] = i;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int fir = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(fir == 0) {
				union(a, b);
			}else {
				if(find_set(a) != find_set(b)) sb.append("NO").append("\n");
				else sb.append("YES").append("\n");
			}
			
		}
		System.out.println(sb);
	}
}
