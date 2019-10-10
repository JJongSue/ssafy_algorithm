package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main1325dfs {
	static int N;
	static boolean[] is_visit;
	static ArrayList<ArrayList<Integer>> al;
	static Vector<Integer> varr[];
	static Vector<Vector<Integer>> v;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		v = new Vector<>();
		//al = new ArrayList<ArrayList<Integer>>();
		varr = new Vector[N+1];
		for(int i=0;i<=N;i++) {
			//al.add(new ArrayList<>());
			varr[i] = new Vector<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			varr[b].add(a);
			//v.get(b).add(a);
			//al.get(b).add(a);
		}
		

		arr = new int[N+1];
		int max = -1;
		StringBuilder sb=new StringBuilder();;
		for(int i=1;i<=N;i++) {			
			is_visit = new boolean[N+1];
			is_visit[i] = true;
			dfs(i, i);
			if(max < arr[i]) {
				sb = new StringBuilder();
				sb.append(i).append(" ");
				
				max = arr[i];
			}else if(max == arr[i]) {
				//qq.add(i);
				sb.append(i).append(" ");
			}
			
		}
		System.out.println(sb);
		
		/*for(int i=1;i<=N;i++) {
			if(arr[i] == max) {
				sb.append(i).append(" ");
			}
		}*/		
		
	}
	static void dfs(int a, int b) {
		for(int tmp : varr[b] ) {
			if(!is_visit[tmp]) {
				is_visit[tmp] = true;
				dfs(a,tmp);
				arr[a]++;
			}
		}
	}
	
	
	
	
}
