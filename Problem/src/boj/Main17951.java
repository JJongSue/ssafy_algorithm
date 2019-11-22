package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main17951 {
	static PriorityQueue<Integer> anspq = new PriorityQueue<>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) anspq.add(0);
		for(int i=0;i<N;i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		while(!pq.isEmpty()) {
			int tmp = anspq.poll();
			int pqtmp = pq.poll();
			tmp += pq.poll();
			anspq.add(tmp);
		}
		System.out.println(anspq.peek());
	}
}
