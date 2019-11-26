package boj;

import java.util.Scanner;
import java.util.Stack;

public class Main17952 {
	static class pair{
		int score;
		int time;
		public pair(int score, int time) {
			super();
			this.score = score;
			this.time = time;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack<pair> st = new Stack<>();
		int ans = 0;
		for(int i=0;i<T;i++) {
			int bool = sc.nextInt();
			if(bool == 1) {
				st.add(new pair(sc.nextInt(), sc.nextInt()-1));
				if(st.peek().time == 0) {
					ans += st.pop().score;
				}
			}else {
				if(!st.isEmpty()) {
					st.peek().time--;
					if(st.peek().time == 0) {
						ans += st.pop().score;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
