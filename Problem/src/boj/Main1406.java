package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1406 {
	static class Node{
		public Node(char now, Node next, Node prev) {
			super();
			this.now = now;
			this.next = next;
			this.prev = prev;
		}
		char now;
		Node next;
		Node prev;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Node now = new Node('A', null, null);
		Node first = now;
		for(int i=0;i<str.length();i++) {
			Node input = new Node(str.charAt(i), null, now);
			now.next = input;
			now = input;
		}
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			System.out.println(now.now);
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.charAt(0) == 'D') {
				if(now.next != null) {
					now = now.next;
				}
			}else if(cmd.charAt(0) == 'L') {
				if(now.prev != null) {
					now = now.prev;
				}
			}else if(cmd.charAt(0) == 'B') {
				if(now.now != 'A') {
					now.prev.next = now.next;
					if(now.next != null) now.next.prev = now.prev;
					now = now.prev;
				}
			}else {
				String input = st.nextToken();
				Node nn = new Node(input.charAt(0), now.next, now);
				now.next = nn;
//				now.prev.next = nn;
				if(now.next != null) now.next.prev = nn;
				now = nn;
			}
		}
		first = first.next;
		while(first != null) {
			System.out.print(first.now);
			first = first.next;
		}
	}
}
