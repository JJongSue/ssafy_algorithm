package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main2002 {
	static String map[];
	static HashMap<String, Integer> hm = new HashMap<>();
	static int m[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new String[N];
		m = new int[N];
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			hm.put(tmp, i);
			map[i] = tmp;
			m[i] = i;
		}
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			m[i] = hm.get(tmp);
			//if(hm.get(tmp) > i) ans++;
//			if(m[hm.get(tmp)] > i) ans++;
//			for(int j=i;j<hm.get(tmp);j++) {
//				m[j]++;
//			}
		}
		int min = m[N-1];
		int ans = 0;
		for(int i=N-2;i>=0;i--) {
			if(m[i] > min) ans++;
			else min = m[i];
			
		}
		System.out.println(ans);
		
	}
}
