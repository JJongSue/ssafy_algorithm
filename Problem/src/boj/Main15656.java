package boj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main15656 {
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, Boolean> hm = new HashMap<>();
	static int N, M;
	static int arr[];
	static boolean is_visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int al[] = new int[M];
		//is_visit = new boolean[N];
		find(0, 0, al);
		System.out.println(sb);
		
	}
	static void find(int now, int cnt, int[] al) {
		//if(now == N) return;
		if(cnt == M) {
			StringBuilder sb2 = new StringBuilder();
			for(int i=0;i<M;i++) {
				sb2.append(al[i]).append(" ");
			}
			if( !hm.containsKey(sb2.toString()) ) {
				
				hm.put(sb2.toString(), true);
				sb.append(sb2).append("\n");				
			}
			return;
		}
		for(int i=0;i<N;i++) {
			//if(is_visit[i]) continue;
			//is_visit[i] =true;
			al[cnt] = arr[i];
			find(0, cnt+1, al);
			//is_visit[i] = false;
		}
		
		
	}
	
}
