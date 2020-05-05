package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String ans = "";
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' ){
				int ch = (str.charAt(i) - 'A' + 13 ) %26;
				ans += (char)(ch + 'A');
			}else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z' ) {
				int ch = (str.charAt(i) - 'a' + 13 ) %26;
				ans += (char)(ch + 'a');
			}else {
				ans += str.charAt(i);
			}
		}
		System.out.println(ans);
	}
}
