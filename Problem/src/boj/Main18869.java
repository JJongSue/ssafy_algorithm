package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main18869 {
	static int N, M;
	static HashMap<String, Integer> hm = new HashMap<>();
	
	static class pair implements Comparable<pair>{
		int x;
		int i;
		public pair(int x, int i) {
			super();
			this.x = x;
			this.i = i;
		}
		
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int ans = 0;
		pair arr[] = new pair[M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[j] = new pair(Integer.parseInt(st.nextToken()), j);
			}
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			int idx = 0;
			int post = arr[0].x;
			sb.append(idx);
			for(int j=1;j<M;j++) {
				if(arr[j].x > arr[j-1].x) idx++;
				sb.append(idx);
			}
			String str = sb.toString();
			if(hm.containsKey(str)) {
				hm.put(str ,hm.get(str)+1);
				if(hm.get(str) == 2) ans++;
				//ans = Math.max(ans, hm.get(str));
			}else {
				hm.put(str, 1);
			}
		}
		System.out.println(ans);
	}
}
