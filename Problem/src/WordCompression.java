import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class WordCompression {
	static Stack<Character> st1 = new Stack<>();
	static Queue<Character> dup= new LinkedList<Character>(), sq = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<tmp.length();i++) {
			sq.add(tmp.charAt(i));
		}
		while(!sq.isEmpty()) {
			char c = sq.poll();
			
			if(!dup.isEmpty()) {
				if(dup.peek() == c) {
					dup.add(c);
					if(dup.size() == N) {
						while(!dup.isEmpty()) dup.poll();
						while(!st1.isEmpty()) {
							if(dup.isEmpty()) {
								dup.add(st1.pop());
							}else {
								if(dup.peek() == st1.peek()) {
									dup.add(st1.pop());
									if(dup.size() == N) {
										while(!dup.isEmpty()) st1.add(dup.poll());
									}
								}else {
									break;
								}
							}
						}
					}
				}else {
					while(!dup.isEmpty()) st1.add(dup.poll());
					dup.add(c);
					while(!st1.isEmpty()) {
						if(dup.isEmpty()) {
							dup.add(st1.pop());
						}else {
							if(dup.peek() == st1.peek()) {
								dup.add(st1.pop());
								if(dup.size() == N) {
									while(!dup.isEmpty()) st1.add(dup.poll());
								}
							}else {
								break;
							}
						}
					}
				}
				continue;
			}
			
			
			dup.add(c);
			
		}
		while(!dup.isEmpty()) {
			st1.add(dup.poll());
		}
		while(!sq.isEmpty()) {
			st1.add(sq.poll());
		}
		Stack<Character> ans = new Stack<>();
		while(!st1.isEmpty()) {
			ans.add(st1.pop());
		}
		String answer = "";
		while(!ans.isEmpty()) {
			answer += ans.pop();
		}
		System.out.println(answer);
		
		
	}
}
