package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(str.charAt(0) != '.') {
			Stack<Character> st = new Stack<>();
			boolean is_yes = true;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i) == '(') st.add('(');
				else if(str.charAt(i) == '[') st.add('[');
				else if(str.charAt(i) == ')') {
					if(st.isEmpty() || st.peek() == '[') {
						is_yes = false;
						break;
					}else {
						st.pop();
					}
				}else if(str.charAt(i) == ']') {
					if(st.isEmpty() || st.peek() == '(') {
						is_yes = false;
						break;
					}else {
						st.pop();
					}
				}
			}
			if(is_yes && st.isEmpty()) System.out.println("yes");
			else System.out.println("no");
			str = br.readLine();
		}
	}
}
