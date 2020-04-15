package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1701 {
	static String str;
	static int N;
	static long ht[];
	static boolean is_two(int size) {
		long hash = 0, DN = 1;
		ht = new long[N-size+1];
		for(int i=0;i<size;i++) {
			hash = hash * 5381 + (str.charAt(i)-'a'+1);
			DN *= 5381;
		}
		ht[0] = hash;
		//System.out.println(size+" "+hash);
		for(int i=size;i<N;i++) {
			hash = hash * 5381 + (str.charAt(i)-'a'+1) - (str.charAt(i-size)-'a'+1) * DN;
			ht[i-size+1] = hash;
		}
		Arrays.sort(ht);
		for(int i=0;i<N-size;i++) {
			if(ht[i] == ht[i+1]) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		N = str.length();
		int L = 1, R = N-1;
		int ans = 0;
		while(L<=R) {
			int mid = (L+R)/2;
			boolean ok = is_two(mid);
			if(ok) {
				L = mid+1;
				ans = mid;
			}else {
				R = mid-1;
			}
		}
		System.out.println(ans);
		
	}
}
