package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		int cnt = 0;
		end: for(int i=0;i<A.length();i++) {
			boolean is_same = true;
			for(int j=0;j<B.length();j++) {
				if(i+j>=A.length()) break end;
				if(A.charAt(i+j) != B.charAt(j)) {
					is_same = false;
					break;
				}
			}
			if(is_same) {
				i = i+B.length()-1;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
