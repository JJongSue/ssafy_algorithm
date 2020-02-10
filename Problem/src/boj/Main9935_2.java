package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main9935_2 {
	static Deque<Character> dq = new LinkedList<Character>();
	static String str, bomb;
	static int is_have[] = new int[129];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		bomb = br.readLine();
		for(int i=0;i<129;i++) is_have[i] = -1;
		for(int i=0;i<bomb.length();i++) {
			int ch = bomb.charAt(i);
			is_have[ch] = i;
		}
		StringBuilder sb = new StringBuilder();
		end:for(int i=0;i<str.length();i++) {
			//System.out.println(i +" : " + str.charAt(i));
			int ch = str.charAt(i);
			if(is_have[ch] == -1) {
				while(!dq.isEmpty()) {
					sb.append(dq.pollFirst());
				}
				sb.append(str.charAt(i));
			}else if(is_have[ch] == 0) {
				Queue<Character> tmp = new LinkedList<Character>();
				int j=0;
				for(j=0;j<bomb.length();j++) {
					if(i+j == str.length()) {
						while(!tmp.isEmpty()) {
							dq.addLast(tmp.poll());
						}
						break end;
					}
					if(bomb.charAt(j) == str.charAt(i+j)) {
						tmp.add(bomb.charAt(j));
					}else break;
				}
				i = i+tmp.size()-1;
				if(bomb.length() != tmp.size()) {
					while(!tmp.isEmpty()) {
						
						dq.addLast(tmp.poll());
					}
				}else {
					
					
				}
			}else {
				if(dq.isEmpty()) {
					sb.append(str.charAt(i));
				}else {
					int tmpch = dq.peekLast();
					
					int tmpch2 = str.charAt(i);
					if(is_have[tmpch]+1 == is_have[tmpch2]) {
						
						Queue<Character> tmp = new LinkedList<Character>();
						for(int j=0;j+is_have[tmpch2]<bomb.length();j++) {
							if(i+j == str.length()) {
								while(!tmp.isEmpty()) {
									dq.addLast(tmp.poll());
								}
								break end;
							}
							if(bomb.charAt(j+is_have[tmpch2]) == str.charAt(i+j)) {
								tmp.add(str.charAt(i+j));
							}else break;
						}
						i = i+tmp.size()-1;
						tmpch2 = str.charAt(i);
						//System.out.println(str.charAt(i));
						if(bomb.length()-1 == is_have[tmpch2]) {
							//System.out.println(i+"delete all not first");
							char chartmp = dq.pollLast();
							while(chartmp != bomb.charAt(0)) {
								chartmp = dq.pollLast();
							}
						}else {
							while(!tmp.isEmpty()) {
								dq.addLast(tmp.poll());
							}
						}
					}else {
						while(!dq.isEmpty()) {
							sb.append(dq.pollFirst());
						}
						sb.append(str.charAt(i));
					}
				}
			}
			
		}
		//System.out.println(dq.size());
		while(!dq.isEmpty()) {
			
			sb.append(dq.pollFirst());
		}
		if(sb.length() == 0) System.out.println("FRULA");
		else System.out.println(sb);
		
	}
}
