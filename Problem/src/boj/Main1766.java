package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1766 {
	static boolean is_visit[];
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int arr[];
	static class pair {
		int go;
		
		public pair( int go) {
			this.go = go;
		}
	}
	static ArrayList<Integer> al[];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		arr = new int[N+1];
		is_visit = new boolean[N+1];
		al = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			arr[J]++;
			al[I].add(J);
		}
		
		for(int i=1;i<=N;i++) {
			if(arr[i] == 0) {
				pq.add(i);
			
			}
		}
		while(!pq.isEmpty()) {
			int tmp = pq.poll();
			sb.append(tmp).append(" ");
			for(int i=0;i<al[tmp].size();i++) {
				arr[al[tmp].get(i)]--;
				if(arr[al[tmp].get(i)] == 0) {
					pq.add(al[tmp].get(i));
				}
			}
		}
		System.out.println(sb);
			
		
	}
}
