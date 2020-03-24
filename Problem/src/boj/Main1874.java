package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1874 {
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean is_ok = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int now = 1;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			int find = Integer.parseInt(br.readLine());
			if(now <= find) {
				for(int j=now;j<=find;j++) {
					stack.add(j);
					sb.append('+').append("\n");
				}
				now = find+1;
				sb.append('-').append("\n");
				stack.pop();
			}else {
				if(!stack.isEmpty() && stack.peek() == find) {
					sb.append('-').append("\n");
					stack.pop();
					continue;
				}
				is_ok = false;
				break;
			}
		}
		if(is_ok) System.out.println(sb);
		else System.out.println("NO");
		//System.out.println(sb);
		
	}
}
