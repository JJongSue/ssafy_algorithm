package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1305 {
	static int N;
	static String str;
	static long ht[];
	static boolean is_two(int mid) {
		long hash = 0, DN = 1;
		for(int i=0;i<mid;i++) {
			hash = hash * 5381 + (str.charAt(i)-'a'+1);
			DN *= 5381;
		}
		ht[0] = hash;
		for(int i=0;i<N-1;i++) {
			hash = hash * 5381 + (str.charAt( (i+mid )%N) - 'a'+1 ) - DN * (str.charAt( (N+i-mid)%N )-'a'+1 );
			ht[i+1] = hash;
			//if(hash != save) return false;
		}
		Arrays.sort(ht);
		for(int i=0;i<N-1;i++) if(ht[i]==ht[i+1]) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		int ans = N;
		ht = new long[N];
		int L = 1, R = N-1;
		while(L<R) {
			int mid = (L+R)/2;
			boolean ok = is_two(mid);
			if(ok) {
				R = mid-1;
				ans = mid;
			}else {
				L = mid+1;
			}
		}
		System.out.println(ans);
	}
}
