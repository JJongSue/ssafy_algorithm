package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1325 {
	static int N;
	static ArrayList<ArrayList<Integer>> al;
	static boolean [] is_visit;
	static int[]arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		al = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=N;i++) {
			al.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			al.get(b).add(a);
		}
		

		arr = new int[N+1];
		int max = -1;
		Queue<Integer> qq = new LinkedList<>();
		for(int i=1;i<=N;i++) {			
			is_visit = new boolean[N+1];
			is_visit[i] = true;
			bfs(i, i);
			if(max < arr[i]) {
				qq.clear();
				qq.add(i);
				max = arr[i];
			}else if(max == arr[i]) {
				qq.add(i);
			}
			
		}
		StringBuilder sb = new StringBuilder();
		/*for(int i=1;i<=N;i++) {
			if(arr[i] == max) {
				sb.append(i).append(" ");
			}
		}*/
		while(!qq.isEmpty()) {
			sb.append(qq.poll()).append(" ");
		}
		System.out.println(sb);
		
		
	}
	static void bfs(int a, int b) {
		for(int tmp : al.get(b)) {
			if(!is_visit[tmp]) {
				is_visit[tmp] = true;
				bfs(a,tmp);
				arr[a]++;
			}
		}
		
	}
	
}
