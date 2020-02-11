package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main11003 {
	//static Deque<Integer> dq = new ArrayDeque();
	static ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
	
	static int N, L, map[];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static class deq{
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N];
		st = new StringTokenizer(br.readLine());
//		map[0] = Integer.parseInt(st.nextToken());
//		dq.offer(0);
		//bw.write(map[dq.peekFirst()]+" ");
		for(int i=0;i<N;i++) {
			map[i] = Integer.parseInt(st.nextToken());
			
			while(!dq.isEmpty() && map[dq.peekLast()] >= map[i]) {
				dq.pollLast();
				//dq.removeLast();
				
			}
			dq.offer(i);
			if(dq.peekFirst()<= i-L) dq.pollFirst();//dq.removeFirst();//dq.pollFirst();
			//dq.addLast(map[i]);
			sb.append(map[dq.peekFirst()]).append(" ");
			//bw.write(map[dq.peekFirst()]+" ");
			
		}
		
//		bw.flush();
//		bw.close();

		System.out.println(sb);
		
		
		
	}
}
