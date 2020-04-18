package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1316 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i=0;i<N;i++) {
			boolean is_visit[] = new boolean[26];
			String str = br.readLine();
			int post = str.charAt(0) - 'a';
			is_visit[post] = true;
			boolean is_plus = true;
			for(int j=1;j<str.length();j++) {
				int ch = str.charAt(j) - 'a';
				if(ch != post) {
					if(is_visit[ch]) {
						is_plus = false;
						break;
					}else {
						post = ch;
						is_visit[ch] = true;
					}
				}
			}
			if(is_plus) ans++;
		}
		System.out.println(ans);
	}
}
