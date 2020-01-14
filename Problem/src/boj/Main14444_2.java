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
		for(int i=0;i<tmp.length();i=i+2) {
			//System.out.println(i);
			s[i] = tmp.charAt(i);
			if(i == N-1) continue;
			s[i+1] = '#';
		}
		int ans = 0;
		int r = -1, k = -1;
		System.out.println(N-1);
		System.out.println(Arrays.toString(size));
		for(int i=0;i<N;i++) {
			//System.out.println(i);
			if(i<=r) size[i] = Math.min(size[2*k-i], r-i);
			while(true) {
				int tmp = size[i];
				System.out.println(i+" "+tmp);
				if((i-size[i]-1<0) || (i+size[i]+1>=N-1)) break;
				if(s[i-1-tmp] == s[i+1+tmp]) size[i]++;
				else break;
			}
//			while(i-size[i]-1>=0 && i+size[i]+1<N &&
//					s[i-1-size[i]] == s[i+1+size[i]]) size[i]++;
			if(r < i+s[i]) {
				r = s[i]+i;
				k = i;
			}
			if(s[i] == '#') {
				ans = Math.max(ans, size[i]*2);
			}else {
				ans = Math.max(ans, size[i]+1);
			}
		}
		System.out.println(ans);
	}
}
