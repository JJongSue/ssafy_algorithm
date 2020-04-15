package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String str = br.readLine();
			boolean is_yes = true;
			Stack<Character> stack = new Stack<Character>();
			for(int i=0;i<str.length();i++) {
				char ch = str.charAt(i);
				if(ch == '(') {
					stack.add('(');
				}else {
					if(stack.isEmpty()) {
						is_yes = false;
						break;
					}else {
						stack.pop();
					}
				}
			}
			if(is_yes && stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
			
		}
	}
}
