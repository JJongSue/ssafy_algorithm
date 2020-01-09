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
		Stack<Integer> sta = new Stack<>();
		int cnt = 0;
		for(int i=0;i<map.length;i++) {
			System.out.println(i+" "+cnt);
			//int cnt = 0;
			if(!sta.isEmpty()) {
				int tmp = sta.peek();
				if(tmp == f[cnt]) {
					cnt++;
					sta.pop();
				}else if( tmp > 127  ) {
					cnt = sta.pop()-127;
					
				}
			}
			if(map[i] == f[cnt]) {
				//Stack<Character> sttmp = new Stack<>();
				cnt++;
				//sttmp.add(map[i]);
				for(int j=cnt;j<f.length&&i+j<map.length;j++) {
					if(map[i+j] == f[j]) {
						//sttmp.add(f[j]);
						cnt++;
						if(cnt == f.length) {
							i += j; 
							cnt = 0;
							break;
						}
					}else {
						cnt = 0;
						sta.add((cnt+127));
						i = i + j -1;
						break;
					}
				}
				
				
			}
			else {
				if(cnt != 0) {
					sta.add((cnt+127));
					System.out.println("cnt : " + cnt);
					cnt = 0;
				}
				if(map[i] == f[0]) {
					System.out.println("same" + map[i]);
					cnt = 1;
				}else {
					System.out.println("input" + map[i]);
					sta.add((int) map[i]);
				}
			}
			
		}
		Stack<Integer> tmps = new Stack<>();
		while(!sta.isEmpty()) {
			tmps.add(sta.pop());
		}
		while(!tmps.isEmpty()) {
			int nums = tmps.pop();
			//System.out.println(nums);
			if(nums>128) {
				for(int i=0;i<nums-127;i++) {
					System.out.print(f[i]);
				}
			}else {
				char ch = (char) nums;
				System.out.print(ch);
			}
		}
	}
}
