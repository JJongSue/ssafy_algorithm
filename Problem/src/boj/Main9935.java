package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char map[] = br.readLine().toCharArray();
		char f[] = br.readLine().toCharArray();
		Stack<Character> sta = new Stack<>();
		for(int i=0;i<map.length;i++) {
			if(map[i] == f[f.length-1]) {
				Stack<Character> tmps = new Stack<>();
				for(int l=f.length-1;l>=0;l--) {
					if(sta.isEmpty()) break;
					else {
						if(sta.peek() == f[l])
						tmps.add(sta.pop());
						else {
							break;
						}
					}
					
				}
			}
		}
	}
}
