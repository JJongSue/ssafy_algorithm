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
//			System.out.println(i+" "+cnt+" "+map[i]);
			//int cnt = 0;
			if(!sta.isEmpty() && cnt == 0) {
				int tmp = sta.peek();
//				System.out.println("tmp : " + tmp);
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
				if(cnt == f.length) { 
					cnt = 0;
					continue;
				}
//				System.out.println("같아서 실행"+cnt);
				//sttmp.add(map[i]);
				int j = cnt;
				int postcnt = cnt;
				for(j=cnt;j<f.length&&i+j-postcnt+1<map.length;j++) {
					if(map[i+j-postcnt+1] == f[j]) {
						//sttmp.add(f[j]);
						cnt++;
						if(cnt == f.length) {
							i += (j-postcnt+1); 
							cnt = 0;
							
						}
					}else {
						//System.out.println(map[i+j] + " " + f[cnt]);
						sta.add((cnt+127));
						cnt = 0;
						i = i + j - postcnt;
						break;
					}
				}
				if(i+j-postcnt+1 == map.length) break;
				
				
				
			}
			else {
				if(cnt != 0) {
					sta.add((cnt+127));
//					System.out.println("cnt : " + cnt);
					cnt = 0;
				}
				if(map[i] == f[0]) {
//					System.out.println("same" + map[i]);
					cnt = 1;
				}else {
//					System.out.println("input" + map[i]);
					sta.add((int) map[i]);
				}
			}
			
		}
//		System.out.println(cnt);
		if(cnt != 0) {
			sta.add((cnt+127));
		}
		Stack<Integer> tmps = new Stack<>();
		while(!sta.isEmpty()) {
			tmps.add(sta.pop());
		}
		if(tmps.isEmpty()) {
			System.out.println("FRULA");
		}
		else {
			while(!tmps.isEmpty()) {
				int nums = tmps.pop();
				//System.out.println(nums);
				if(nums>=128) {
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
}
