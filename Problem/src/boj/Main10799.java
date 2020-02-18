package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10799 {
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		int ans = 0;
		for(int i=0;i<tmp.length();i++) {
			if(tmp.charAt(i) == '(') {
				stack.add(0);
			}else if(tmp.charAt(i-1) == '('){
				stack.pop();
				ans += stack.size();
			}else {
				stack.pop();
				ans++;
			}
		}
		System.out.println(ans);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
