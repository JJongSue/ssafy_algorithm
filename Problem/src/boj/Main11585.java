package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11585 {
	static int N;
	static char map[];
	static long save = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			save = save * 5381 + (st.nextToken().charAt(0) - 'a' + 1);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			map[i] = st.nextToken().charAt(0);
		}
		
		
		long hash = 0;
		int ans = 0;
		long DN = 1;
		for(int i=0;i<N;i++) {
			hash = hash * 5381 + (map[i] - 'a' + 1);
			DN *= 5381;
		}
		if(hash == save) ans++;
		for(int i=1;i<N;i++) {
			hash = hash * 5381 + (map[i-1] - 'a' + 1) - DN * (map[i-1]-'a'+1);
			if(hash == save) ans++;
		}
		for(int i=N;i>1;i--) {
			if(N%i == 0 && ans%i == 0) {
				N = N/i;
				ans = ans/i;
			}
			if(N == 1 || ans == 1) break;
		}
		System.out.println(ans+"/"+N);
		
		
	}
}
