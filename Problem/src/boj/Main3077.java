package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main3077 {
	static int N;
	static String map[];
	static HashMap<String, Integer> hm = new HashMap<>();
	public static void main(String[] args) throws IllegalArgumentException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new String[N];
		for(int i =0;i<N;i++) {
			map[i] = st.nextToken();
		}
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			hm.put(st.nextToken(), i);
		}
		int ans = 0;
		int a = 0;
		for(int i=0;i<N-1;i++) {
			a = hm.get(map[i]);
			for(int j=i+1;j<N;j++) {
				if(a < hm.get(map[j])) ans++;
				
			}
		}
		
		System.out.println(ans+"/"+(N*(N-1)));
	}
}
