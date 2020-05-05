package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1713 {
	static class photo implements Comparable<photo>{
		int now;
		int time;
		int cnt;
		public photo(int now, int time, int cnt) {
			super();
			this.now = now;
			this.time = time;
			this.cnt = cnt;
		}		
		
		@Override
		public int compareTo(photo o) {
			if(o.cnt == this.cnt) return this.time - o.time;
			return this.cnt - o.cnt;
		}
	}
	static int N, M, arr[][] = new int[101][2];
	static int map[], size = 0;
	static PriorityQueue<photo> pq = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(arr[tmp][0] != 0) {
				arr[tmp][0]++;
				pq.add(new photo(tmp, arr[tmp][1], arr[tmp][0]));
			}else {
				
				
				if(size == N) {
					while(!pq.isEmpty()) {
						photo p = pq.poll();
						if( arr[p.now][0] == p.cnt) {
							arr[p.now][0] = 0;
							break;
						}
					}
					size--;
				}
				size++;
				arr[tmp][0] = 1;
				arr[tmp][1] = i;
				pq.add(new photo(tmp, i, 1));
				
			}
			
		}
		StringBuilder sb = new StringBuilder();
		int ans[] = new int[size];
		int now = 0;
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		while(!pq.isEmpty()) {
			pq2.add(pq.poll().now);
		}
		int first = 0;
		if(pq2.isEmpty()) {
			first = pq2.poll();
			System.out.print(first+ " ");
			now++;
		}
		while(!pq2.isEmpty()) {
			if(now == N) break;
			int tmp = pq2.poll();
			if(first != tmp) {
				System.out.print(tmp+" ");
				first=tmp;
				now++;
			}
			
		}
	}
}
