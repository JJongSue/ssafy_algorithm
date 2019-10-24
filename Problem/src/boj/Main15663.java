package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main15663 {
	static int N, M;
	static Integer []arr;
	static HashMap<String, Boolean> hm;
	static boolean is_visit[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new Integer[N];
		is_visit = new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		hm = new HashMap<>();
		
	}
	static void comb(int now, int cnt, String ans) {		
		if(cnt == M) {
			if(!hm.containsKey(ans)) {
				System.out.println(ans);
				hm.put(ans, true);
			}
			return;
		}
		for(int i=0;i<N;i++) {
			is_visit
			comb(now+1,cnt+1,ans+" "+arr[i]);
		}
	}
}
