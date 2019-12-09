package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main11286 {
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				int a = Math.abs(o1);
				int b = Math.abs(o2);
				if(a == b) {
					return o1-o2;
				}
				return a-b;
			}

			
		});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					sb.append(pq.poll()).append("\n");
				}
			}else {
				pq.add(tmp);
			}
		}
		System.out.println(sb);
	}
}
