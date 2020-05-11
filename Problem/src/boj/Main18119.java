package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main18119 {
	static int Scnt[] = new int[(1<<27)];
	
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int output = (1<<27)-1;
		System.out.println(output);
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			int dp = 0;
			for(int j=0;j<tmp.length();j++) {
				int ch = tmp.charAt(j) - 'a';
				dp = (dp | (1<<ch));
			}
			Scnt[dp]++;
			System.out.println(dp);
			for(int j=0;j<26;j++) {
				if((dp & (1<<j)) == 0 ) {	
//					System.out.println((dp|(1<<j)));
					Scnt[(dp|(1<<j))]++;
				}
			}
		}
		
		int now = (1<<27)-1;
		
		int ans = Scnt[now];
		System.out.println(now);
		System.out.println(Scnt[now]);
		System.out.println("println");
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			char ch = st.nextToken().charAt(0);
			
			if(cmd == '2') {
				if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') continue;
				now = (now | (1<<(ch-'a')));
				ans = Scnt[now];
			}else {
				if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') continue;
				int t = ~(1<<(ch-'a'));
				now = (now & t);
				ans = Scnt[now];
			}
			System.out.println(ans);
		}
		
	}

}
