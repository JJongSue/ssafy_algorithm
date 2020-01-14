package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14444 {
	static String str;
	static int ans=0;
	static void binary_Search(int l, int r) {
		if(l>r) return;
		int mid = (l+r) / 2;
		if(ans > mid) return;
		System.out.println(l+" "+r);
		long h1 = 0;
		long h2 = 0;
		boolean is_ok = false;
		end:for(int i=0;i+mid-1<str.length();i++) {
			h1 = 0;
			h2 = 0;
			for(int j=0;j<mid/2;j++) {
				h1 = (h1*5381) + (str.charAt(i+j)-'a');
				h2 = (h2*5381) + (str.charAt(i+mid-1-j)-'a');
			}
			if(h1 == h2) {
				ans = Math.max(ans, mid);
				binary_Search(mid+1, r);
				return;
			}
			
			
		}
		binary_Search(mid+1, r);
		binary_Search(l, mid-1);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		int l = 1, r = str.length();
		//int ans = 0;
		binary_Search(l, r);
		System.out.println(ans);
		
	}
}
