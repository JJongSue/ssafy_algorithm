package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main3988 {
	static int N, K;
	static int map[];
	static Deque<Integer> dq = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) map[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(map);
		int m = map[1]-map[0];
		int M = map[N-K-1] - map[0];
		for(int i=1;i<N-K;i++) {
			//System.out.println(i);
			int tmp = map[i] - map[i-1];
			while(!dq.isEmpty()) {
				if(dq.peekLast() > tmp) dq.pollLast();
				else break;
			}
			dq.addLast(tmp);
			m = Math.min(m, tmp);
		}
		int ans = M + m;
		for(int i=N-K;i<N;i++) {
			//System.out.println(i);
			M = map[i] - map[i-(N-K-1)];
			if(map[i-(N-K-1)]-map[i-N+K] == m) {
				dq.pollFirst();
			}
			int tmp = map[i] - map[i-1];
			while(!dq.isEmpty()) {
				if(dq.peekLast() > tmp) dq.pollLast();
				else break;
				
			}
			dq.addLast(tmp);
			m = dq.peekFirst();
			m = Math.min(m, tmp);
			ans = Math.min(ans, M+m);
		}
		
		System.out.println(ans);
	}
	
}
