package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3289 {
	static int parents[];
	
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
//		System.out.println(parents[px]);
//		System.out.println(parents[py]);
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			for(int i=1;i<=N;i++) parents[i] = -1;			
			for(int i=0;i<M;i++) {	
				st = new StringTokenizer(br.readLine());
				int tmp = Integer.parseInt(st.nextToken());
				int tmpx = Integer.parseInt(st.nextToken());
				int tmpy = Integer.parseInt(st.nextToken());
				if(tmp == 0) {
					union(tmpx, tmpy);
				}else {					
					if(find_set(tmpx) == find_set(tmpy)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
