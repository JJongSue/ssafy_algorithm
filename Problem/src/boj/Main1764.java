package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1764 {
	static HashSet<String> hs = new HashSet<>();
	static PriorityQueue<String> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			hs.add(str);
		}
		for(int i=0;i<M;i++) {
			String tmp = br.readLine();
			if(hs.contains(tmp)){
				pq.add(tmp);
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
