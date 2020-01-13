package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18119_1 {
	static int N, M;
	static int dp[] = new int[(1<<27)];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			boolean is_visit[] = new boolean[26];
			int where = 0;
			for(int j=0;j<tmp.length();j++) {
				int ch = tmp.charAt(j) - 'a';
				if(!is_visit[ch]) {
					is_visit[ch] = true;
					where += (1<<ch);
				}
			}
			System.out.println(where);
//			for(int j=where;j<(1<<27);j=(j<<1)) {
//				dp[where]++;
//			}
			dp[where]++;
		}
		
		int now = (1<<27) - 1;
		//System.out.println(now);
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			int ch = c -'a';
			if(cmd == 1) {
				now = now - (1<<ch);
			}else {
				now = now + (1<<ch);
			}
			System.out.println(dp[now]);
		}
		
		//System.out.println(dp[0]);
	}
}
