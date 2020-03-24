package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder ans = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch == '<') {
				for(int j=i;j<str.length();j++) {
					if(str.charAt(j) == '>') {
						i = j;
						break;
					}
					ans.append(str.charAt(j));
				}
				ans.append('>');
			}else if( (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') ) {
				Stack<Character> stack = new Stack<>();
				for(int j=i;j<str.length();j++) {
					if((str.charAt(j) < 'a' || str.charAt(j) > 'z') && (str.charAt(j) < '0' || str.charAt(j) > '9' )) {
						i = j-1;
						break;
					}
					if(j == str.length()-1) i = str.length()-1;
					stack.add(str.charAt(j));
				}
				while(!stack.isEmpty()) ans.append(stack.pop());
			}else {
				ans.append(" ");
				
			}
		}
		System.out.println(ans);
	}
}
