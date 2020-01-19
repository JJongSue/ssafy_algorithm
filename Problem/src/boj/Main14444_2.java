package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main14444_2 {
	static char s[];
	static int size[];
	static String tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tmp = br.readLine();
		int N = tmp.length()*2;
		s = new char[tmp.length()*2-1];
		size = new int[tmp.length()*2-1];
		for(int i=0;i<tmp.length();i++) {
			s[i*2] = tmp.charAt(i);
			if(i == tmp.length()-1) continue;
			s[i*2+1] = '#';
		}
//		for(int i=0;i<tmp.length();i=i+2) {
//			//System.out.println(i);
//			s[i] = tmp.charAt(i);
//			if(i == N-2) continue;
//			s[i+1] = '#';
//		}
		int ans = 0;
		int r = -1, k = -1;
		//System.out.println(N-1);
		//System.out.println(Arrays.toString(s));
		for(int i=0;i<N-1;i++) {
			//System.out.println(i + " " + r);
			//System.out.println(ans);
			if(i<=r) size[i] = Math.min(size[2*k-i], r-i);
			while((i-size[i]-1>=0) && (i+size[i]+1<N-1) && s[i-1-size[i]] == s[i+1+size[i]]) {
				size[i]++;
			}
//			while(true) {
//				if((i-size[i]-1<0) || (i+size[i]+1>=N-1)) break;
//				int tmp = size[i];
//				//System.out.println(i+" "+tmp);
//				if(s[i-1-tmp] == s[i+1+tmp]) size[i]++;
//				else break;
//			}
//			while(i-size[i]-1>=0 && i+size[i]+1<N &&
//					s[i-1-size[i]] == s[i+1+size[i]]) size[i]++;
			if(r < i+size[i]) {
				r = size[i]+i;
				k = i;
			}
			if(s[i] == '#') {
				int cnt = size[i]/2 + size[i]%2;
				//System.out.println(i + " "+ (size[i]));
				if(size[i] == 2) ans = Math.max(ans, size[i]);
				else ans = Math.max(ans, cnt*2);
			}else {
				if(size[i] == 1) {
					size[i] = 0;
					continue;
				}
				//System.out.println(i + " "+ (size[i]+1));
				int cnt = (size[i] / 2) * 2 +1;
				ans = Math.max(ans, cnt);
			}
		}
		//if(tmp.length() == 2 && tmp.charAt(0) == tmp.charAt(1)) ans = 2;
		System.out.println(ans);
	}
}
