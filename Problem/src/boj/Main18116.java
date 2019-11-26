package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18116 {
	static int[] parents;
	static int find_set(int x) {
		if(parents[x] < 0) return x;
		return parents[x] = find_set(parents[x]);
	}
	static void union(int x, int y) {
		int px = find_set(x);
		int py = find_set(y);
		if(px == py) return;
		parents[px] += parents[py];
		parents[py] = px;
		//find_set(y);
		//find_set(x);
	}	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		parents = new int[1000_001];
		
		for(int i=1;i<=1000_000;i++) parents[i] = -1;

		//System.out.println(parents[1000_000]);
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("I")) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int px = find_set(x);
				int py = find_set(y);
				//if(parents[x]!=-2 && parents[x]>0 && parents[y]!=-2 && parents[y]>0 )
				union(x, y);				
			}else {
				sb.append((-1*parents[find_set(Integer.parseInt(st.nextToken()))])).append("\n");
//				System.out.println((-1*parents[find_set(Integer.parseInt(st.nextToken()))]));
			}
		}
		//System.out.println(parents[1]);
		System.out.println(sb);
		
	}
}
