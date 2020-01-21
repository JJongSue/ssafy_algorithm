package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1976 {
	static int parents[];
	static int get_parents(int x) {
		if(parents[x]<0) return x;
		return parents[x] = get_parents(parents[x]);
	}
	static void union(int x, int y) {
		int px = get_parents(x);
		int py = get_parents(y);
		parents[px] += parents[py];
		parents[py] = px;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		for(int i=1;i<=N;i++) {
			parents[i] = -1;
		}
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int x = Integer.parseInt(st.nextToken());
				if(i < j) {
					
					if(x==1 && get_parents(i+1) != get_parents(j+1) ) {
						union(i+1, j+1);
					}
				}
				
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		boolean is_yes = true;
		int now = get_parents(x);
		for(int i=1;i<M;i++) {
			x = Integer.parseInt(st.nextToken());
			if(now != get_parents(x)) {
				is_yes = false;
				break;
			}
		}
		if(is_yes) System.out.println("YES");
		else System.out.println("NO");
		
	}
}
