package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main10866 {
	static Deque<Integer> dq = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push_back")) {
				dq.add(Integer.parseInt(st.nextToken()));
			}else if(cmd.equals("push_front")) {
				dq.addFirst(Integer.parseInt(st.nextToken()));
			}else if(cmd.equals("pop_front")) {
				if(!dq.isEmpty()) {
					System.out.println(dq.pollFirst());
					continue;
				}
				System.out.println(-1);
			}else if(cmd.equals("pop_back")) {
				if(!dq.isEmpty()) {
					System.out.println(dq.pollLast());
					continue;
				}
				System.out.println(-1);
			}else if(cmd.equals("size")) {
				System.out.println(dq.size());
			}else if(cmd.equals("empty")) {
				if(dq.isEmpty()) {
					System.out.println(1);
				}else
					System.out.println(0);
			}else if(cmd.equals("front")) {
				if(dq.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(dq.peekFirst());
				
			}else if(cmd.equals("back")) {
				if(dq.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(dq.peekLast());
				
			}
		}
	}
}
