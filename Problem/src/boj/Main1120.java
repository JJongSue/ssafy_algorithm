package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int min = B.length();
		while(A.length()<=B.length()) {
			int cnt=0;
			for(int i=0;i<A.length();i++) {
				if(A.charAt(i) == ' ') continue;
				if(A.charAt(i) != B.charAt(i)) cnt++;
			}
			//cnt += (B.length()-A.length()); 
			min = Math.min(min, cnt);
			
			A = " "+A;
		}
		System.out.println(min);
	}
}
