package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1325 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=N;i++) {
			al.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			al.get(b).add(a);
		}
		
		
		boolean [] is_visit;
		int arr[] = new int[N+1];
		int max = -1;
		for(int i=1;i<=N;i++) {
			is_visit = new boolean[N+1];
			is_visit[i] = true;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(i);
			while(!q.isEmpty()) {
				int tmp = q.poll();
				for(int j=0;j<al.get(tmp).size();j++) {
					if(!is_visit[al.get(tmp).get(j)] ) {
						is_visit[al.get(tmp).get(j)] = true;
						q.add(al.get(tmp).get(j));
						arr[i]++;
					}
				}
			}
			if(max < arr[i]) max = arr[i];
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			if(arr[i] == max) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
		
		
	}
}
