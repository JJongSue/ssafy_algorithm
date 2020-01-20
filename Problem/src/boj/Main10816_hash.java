package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main10816_hash {
	static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(hm.containsKey(tmp)) {
				int cnt = hm.get(tmp);
				hm.replace(tmp, cnt+1);
			}else {
				hm.put(tmp, 1);
			}
		}
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(hm.containsKey(tmp)) {
				int cnt = hm.get(tmp);
				sb.append(cnt).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
		
		
	}
}
