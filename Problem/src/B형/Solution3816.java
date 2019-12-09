package BÇü;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3816 {
	static int ana[] = new int[26];
	static int ana2[] = new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String tmp = st.nextToken();
		int analength = tmp.length();
		for(int i=0;i<analength;i++) ana[tmp.charAt(i)-'a']++;
		tmp = st.nextToken();
		for(int i=0;i<analength;i++) ana2[tmp.charAt(i)-'a']++;
		int cnt = 0;
		boolean is_ok = true;
		for(int i=0;i<26;i++) {
			if(ana[i] != ana2[i]) {
				is_ok = false;
				break;
			}
		}
		if(is_ok) cnt++;
		
		for(int i=tmp.length();i<)
		
	}
}
