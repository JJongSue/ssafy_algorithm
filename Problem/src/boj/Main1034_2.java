package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1034_2 {
	static int N, M;
	static HashMap<String, map> hm = new HashMap<String, map>();
	static String arr[];
	static int max = 0;
	static class map{
		int cnt;
		int needcnt;
		public map(int cnt, int needcnt) {
			super();
			this.cnt = cnt;
			this.needcnt = needcnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new String[N];
		
		for(int i=0;i<N;i++) arr[i] = br.readLine();
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String tmp = arr[i];
			
			if(hm.containsKey(tmp)) {
				map tmpmap = hm.get(tmp);
				hm.replace(tmp, new map(tmpmap.cnt+1, tmpmap.needcnt));
			}else {
				int zerocnt = 0;
				for(int s=0;s<M;s++) {
					if(tmp.charAt(s) == '0') zerocnt++;
				}
				hm.put(tmp, new map(1, zerocnt));
			}
			map tmpmap = hm.get(tmp);
			if(tmpmap.needcnt <= K && tmpmap.needcnt%2 == K % 2)
			max = Math.max(max, tmpmap.cnt);
		}
		System.out.println(max);
		
	}
}
