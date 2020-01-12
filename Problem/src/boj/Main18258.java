package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18258 {
	static final int max_size = 2_000_001;
	static class Queue{
		int q[];
		int size = 0;
		int front;
		int back;
		public Queue() {
			q = new int[max_size];
			size = 0;
			front = 0;
			back = 0;
		}
		
		void push(int x) {
			q[back++] = x;
			size++;
		}
		int pop() {
			if(is_empty()) return -1;
			size--;
			return q[front++];
		}
		boolean is_empty() {
			if(size == 0) {
				return true;
			}
			return false;
		}
		int front() {
			if(is_empty()) return -1;
			return q[front];
		}
		int back() {
			if(is_empty()) return -1;
			return q[back-1];
		}
		void cmd(String cmd) {
			if(cmd.equals("push")) {
				push(Integer.parseInt(st.nextToken()));
			}else if(cmd.equals("pop")) {
				sb.append(pop()).append("\n");
			}else if(cmd.equals("size")) {
				sb.append(size).append("\n");
			}else if(cmd.equals("empty")) {
				if(is_empty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}else if(cmd.equals("front")) {
				sb.append(front()).append("\n");
			}else if(cmd.equals("back")) {
				sb.append(back()).append("\n");
			}
		}
	}
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue q = new Queue();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			q.cmd(cmd);
		}
		System.out.println(sb);
	}
}
