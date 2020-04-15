package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4354 {
	static String str;
	static int N;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		StringBuilder sb = new StringBuilder();
		while(str.charAt(0) != '.') {
			//System.out.println(str);
			N = str.length();
			boolean is_N = true;
			for(int i=0;i<N-1;i++) {
				if(str.charAt(i) != str.charAt(i+1)) {
					is_N = false;
					break;
				}
			}
			if (is_N) {
				sb.append(N).append("\n");
				str = br.readLine();
				continue;
			}
			int ans = 1;
			for(int i=N-1;i>1;i--) {
				if(N%i != 0) continue;
				int x = N/i;
				long hash = 0;
				for(int j=0;j<x;j++) {
					hash = hash * 5381 + (str.charAt(j)-'a'+1);
				}
				long save = hash;
				boolean ok = true;
				for(int j=1;j<i;j++) {
					hash = 0;
					for(int k=0;k<x;k++) {
						hash = hash * 5381 + (str.charAt(j*x+k)-'a'+1);
					}
					if(save != hash) {
						ok = false;
						break;
					}
				}
				if(ok) {
					ans = i;
					break;
				}
			}
			sb.append(ans).append("\n");
			str = br.readLine();
		}
		System.out.println(sb);
	}
}
