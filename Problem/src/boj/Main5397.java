package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main5397 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T;tc++) {
			String tmp = br.readLine();
			/*Queue<Character> left = new LinkedList<Character>();
			Queue<Character> right = new LinkedList<Character>();*/
			Stack<Character> left = new Stack<Character>();
			Stack<Character> right = new Stack<Character>();
			for(int i=0;i<tmp.length();i++) {
				if(tmp.charAt(i) == '<') {
					if(!left.isEmpty()) {
						right.add(left.pop());
					}
				}else if(tmp.charAt(i) == '>') {
					if(!right.isEmpty()) {
						left.add(right.pop());
					}
				}else if(tmp.charAt(i) == '-') {
					if(!left.isEmpty()) left.pop();
				}else {
					left.add(tmp.charAt(i));
				}
			}
			/*String lback = "";
			String rback = "";*/
			while(!left.isEmpty()) {
				//lback += left.pop();
				right.add(left.pop());
			}
			while(!right.isEmpty()) {
				bw.append(right.pop());
			}
			bw.append("\n");
		}
		bw.flush();
		//System.out.println(sb);
	}
}
