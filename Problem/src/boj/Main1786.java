package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1786 {
	static String find;
	static int f[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		find = br.readLine();
		f = new int[find.length()];
		set_failFunction();
		//System.out.println(Arrays.toString(f));
		int post = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		int j=0;
		for(int i=0;i<str.length();i++) {
			while(j>0 && str.charAt(i) != find.charAt(j) ) j = f[j-1];
			//System.out.println(j);
			if(str.charAt(i) == find.charAt(j)) {
				//System.out.println(i+" "+j);
				if(j == find.length()-1) {
					q.add(i-find.length()+2);
					j = f[j];
				}else j++;
				}
			//System.out.println(j);
		}
		
//		for(int i=0;i<str.length();i++) {
//			//System.out.println(i);
//			if(i+find.length()-1 >= str.length()) break;
//			boolean is_same = true;
//			if(post == 0 && str.charAt(i) != find.charAt(0)) {
//				continue;
//			}
//			for(int j=post;j<find.length();j++) {
//				
//				if(str.charAt(i+j) != find.charAt(j)) {
//					is_same = false;
//					post = f[j-1];
//					i = i+j-f[j-1]-1;
//					break;
//				}
//			}
//			if(is_same) q.add(i+1);
//			post = f[f.length-1];
//			//System.out.println(str.charAt(i));
//		}
		StringBuilder sb = new StringBuilder();
		sb.append(q.size()).append("\n");
		while(!q.isEmpty()) {
			sb.append(q.poll()).append(" ");
			
		}
		System.out.println(sb);
			
		
	}
	
	static void set_failFunction() {
		//System.out.println(find);
		int j=0;
		for(int i=1;i<find.length();i++) {
			while(j>0 && find.charAt(i) != find.charAt(j)) j = f[j-1];
			if(find.charAt(i) == find.charAt(j)) f[i] = ++j;
		}
		
	}
}
